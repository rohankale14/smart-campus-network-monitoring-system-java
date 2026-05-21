
package com.smartcampus.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NetworkMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetworkMonitorApplication.class, args);
        System.out.println("Smart Campus Grafana Dashboard Started");
    }
}
