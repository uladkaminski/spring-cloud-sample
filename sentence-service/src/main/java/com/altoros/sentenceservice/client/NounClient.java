package com.altoros.sentenceservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("noun-service")
public interface NounClient {

    @GetMapping
    String getWord();

}
