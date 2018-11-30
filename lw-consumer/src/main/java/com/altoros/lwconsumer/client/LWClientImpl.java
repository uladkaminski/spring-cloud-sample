package com.altoros.lwconsumer.client;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class LWClientImpl implements LWClient {

    private final RestTemplate restTemplate;

    @Autowired
    public LWClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    @HystrixCommand(fallbackMethod = "defaultLuckyWord")
    public String receiveLuckyWord() {
        return restTemplate.getForObject("//lucky-word/lucky-word", String.class);
    }
    @Override
    @HystrixCommand(fallbackMethod = "defaultWord")
    public String receiveDefaultWord() {
        return restTemplate.getForObject("//lucky-word/default", String.class);
    }

    private String defaultWord() {
        return "Default word";
    }


    private String defaultLuckyWord() {
        return "Default lucky word";
    }

}
