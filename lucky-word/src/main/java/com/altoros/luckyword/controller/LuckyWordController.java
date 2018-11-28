package com.altoros.luckyword.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class LuckyWordController {

    @Value("${word-config.lucky-world: default}")
    private String luckyWord;

    @Autowired
    private Integer id;

    @GetMapping("lucky-word")
    public String showLuckyWorld() {
        return "Lucky word is " + luckyWord + " from service " + id;
    }

    @GetMapping("/default")
    public String showDefaultWorld() {
        return "Default word is default from service " + id;
    }
}
