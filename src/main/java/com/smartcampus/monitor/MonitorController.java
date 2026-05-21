package com.smartcampus.monitor;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonitorController {

    @GetMapping("/api/network/wifi")
    public ResponseEntity<?> getWifiNetworks() {
        try {

            ProcessBuilder pb = new ProcessBuilder(
                "cmd.exe", "/c", "python wifi.py"
            );

            pb.directory(new java.io.File("D:\\final year project\\smartcampusnetworkmonitoringsystem"));

            pb.redirectErrorStream(true);

            Process process = pb.start();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );

            StringBuilder output = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                output.append(line);
            }

            process.waitFor();

            return ResponseEntity.ok(output.toString());

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("WiFi scan failed");
        }
    }
}