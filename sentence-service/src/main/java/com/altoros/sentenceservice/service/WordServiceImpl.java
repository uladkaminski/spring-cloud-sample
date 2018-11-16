package com.altoros.sentenceservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WordServiceImpl implements WordService {

    private final RestTemplate restTemplate;

    @Autowired
    public WordServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    @HystrixCommand(fallbackMethod = "defaultWord")
    public String getWord(String service) {
        return restTemplate.getForObject("http://" + service, String.class);
    }

    public String defaultWord(String service){
        return service;
    }
}
