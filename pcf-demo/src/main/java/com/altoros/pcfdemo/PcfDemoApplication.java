package com.altoros.pcfdemo;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class PcfDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PcfDemoApplication.class, args);
    }
}
