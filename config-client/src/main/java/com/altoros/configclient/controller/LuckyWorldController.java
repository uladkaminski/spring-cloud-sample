package com.altoros.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class LuckyWorldController {

    @Value("${word-config.lucky-world}")
    private String luckyWord;

    @GetMapping("lucky-world")
    public String showLuckyWorld() {
        return "Lucky word is " + luckyWord;
    }
}
