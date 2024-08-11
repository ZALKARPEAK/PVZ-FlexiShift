package com.example.shiftservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableScheduling
@ConditionalOnProperty(name="scheduler.enabled", matchIfMissing = true)
public class ShiftServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiftServiceApplication.class, args);
    }

}
