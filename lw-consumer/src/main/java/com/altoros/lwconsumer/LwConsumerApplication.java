package com.altoros.lwconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

    @SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableDiscoveryClient
@EnableCircuitBreaker
public class LwConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LwConsumerApplication.class, args);
    }
}
