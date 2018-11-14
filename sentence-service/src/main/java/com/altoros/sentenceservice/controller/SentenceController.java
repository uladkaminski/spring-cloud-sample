package com.altoros.sentenceservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
public class SentenceController {

    private final DiscoveryClient discoveryClient;

    @Autowired
    public SentenceController(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("/sentence")
    public String getSentence() {
        return getWord("subject-service") + " "
                + getWord("verb-service") + " "
                + getWord("article-service") + " "
                + getWord("adjective-service") + " "
                + getWord("noun-service") + ".";
    }

    private String getWord(String service) {
        List<ServiceInstance> instances = discoveryClient.getInstances(service);
        if (instances != null && instances.size() > 0) {
            URI uri = instances.get(0).getUri();
            if (uri != null) {
                return new RestTemplate().getForObject(uri, String.class);
            }

        }
        return null;
    }
}
