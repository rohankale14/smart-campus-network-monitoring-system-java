package com.smartcampus.monitor;

import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import java.net.InetAddress;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class MonitorService {

    private final List<String> targets = Arrays.asList(
            "8.8.8.8",       // Google DNS
            "1.1.1.1",       // Cloudflare
            "google.com",
            "amazon.com"
    );

    private final Map<String, Map<String, Object>> networkData = new ConcurrentHashMap<>();

    @PostConstruct
    public void startMonitoring() {
        new Thread(() -> {
            while (true) {
                for (String target : targets) {
                    monitorTarget(target);
                }

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void monitorTarget(String target) {
        try {
            long start = System.currentTimeMillis();

            boolean reachable = InetAddress.getByName(target).isReachable(2000);

            long latency = System.currentTimeMillis() - start;

            Map<String, Object> data = networkData.getOrDefault(target, new HashMap<>());

            int total = (int) data.getOrDefault("total", 0) + 1;
            int success = (int) data.getOrDefault("success", 0);

            if (reachable) success++;

            double availability = (success * 100.0) / total;

            // 🔥 Anomaly Detection
            String anomaly = "NORMAL";
            if (!reachable) anomaly = "DOWN";
            else if (latency > 150) anomaly = "HIGH_LATENCY";

            data.put("target", target);
            data.put("status", reachable ? "UP" : "DOWN");
            data.put("latency", latency);
            data.put("availability", availability);
            data.put("anomaly", anomaly);
            data.put("total", total);
            data.put("success", success);

            networkData.put(target, data);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Collection<Map<String, Object>> getAllNetworks() {
        return networkData.values();
    }
}