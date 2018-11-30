package com.altoros.lwconsumer.controller;

import com.altoros.lwconsumer.client.LWClient;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class LWController {

    private final LWClient lwClient;

    private final DiscoveryClient discoveryClient;


    @Autowired
    public LWController(LWClient lwClient, DiscoveryClient discoveryClient) {
        this.lwClient = lwClient;
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("lw")
    public String receiveLuckyWord() {
        return lwClient.receiveLuckyWord();
    }

    @GetMapping("dw")
    public String receiveDefaultWord() {
        return lwClient.receiveDefaultWord();
    }

    @GetMapping("/sv")
    public String servers() throws IOException {
        List<ServiceInstance> instances = discoveryClient.getInstances("lucky-word");
        return new ObjectMapper().writeValueAsString(instances);
    }

}
