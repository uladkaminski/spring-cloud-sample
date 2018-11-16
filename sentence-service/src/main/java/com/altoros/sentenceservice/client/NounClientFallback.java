package com.altoros.sentenceservice.client;

import org.springframework.stereotype.Component;

@Component
public class NounClientFallback implements NounClient {
    @Override
    public String getWord() {
        return "default";
    }
}
