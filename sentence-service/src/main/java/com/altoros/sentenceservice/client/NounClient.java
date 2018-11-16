package com.altoros.sentenceservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "noun-service", fallback = NounClientFallback.class)
public interface NounClient {

    @GetMapping
    String getWord();

}
