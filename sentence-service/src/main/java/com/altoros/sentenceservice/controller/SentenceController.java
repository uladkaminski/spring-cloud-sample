package com.altoros.sentenceservice.controller;

import com.altoros.sentenceservice.client.NounClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SentenceController {

    private final RestTemplate restTemplate;
    private final NounClient nounClient;

    @Autowired
    public SentenceController(RestTemplate restTemplate, NounClient nounClient) {
        this.restTemplate = restTemplate;
        this.nounClient = nounClient;
    }

    @GetMapping("/sentence")
    public String getSentence() {
        return getWord("subject-service") + " "
                + getWord("verb-service") + " "
                + getWord("article-service") + " "
                + getWord("adjective-service") + " "
                + nounClient.getWord() + ".";
    }

    public String defaultWord(String service){
        return service;
    }
    @HystrixCommand(fallbackMethod = "defaultWord")
    String getWord(String service) {
        return restTemplate.getForObject("http://" + service, String.class);
    }

}
