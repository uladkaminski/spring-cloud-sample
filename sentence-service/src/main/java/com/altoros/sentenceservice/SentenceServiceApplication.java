package com.altoros.sentenceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SentenceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentenceServiceApplication.class, args);
    }
}
