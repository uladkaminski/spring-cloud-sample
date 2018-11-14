package com.altoros.wordservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordController {
    @Value("${words}")
    private String words;

    @GetMapping("/")
    public String getWord(){
        String[] wordArray = words.split(",");
        return wordArray[(int)Math.round(Math.random() * (wordArray.length - 1))];
    }

}
