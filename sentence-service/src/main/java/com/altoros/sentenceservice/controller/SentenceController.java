package com.altoros.sentenceservice.controller;

import com.altoros.sentenceservice.client.NounClient;
import com.altoros.sentenceservice.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentenceController {

    private final WordService wordService;
    private final NounClient nounClient;

    @Autowired
    public SentenceController(WordService wordService, NounClient nounClient) {
        this.wordService = wordService;
        this.nounClient = nounClient;
    }

    @GetMapping("/sentence")
    public String getSentence() {
        return wordService.getWord("subject-service") + " "
                + wordService.getWord("verb-service") + " "
                + wordService.getWord("article-service") + " "
                + wordService.getWord("adjective-service") + " "
                + nounClient.getWord() + ".";
    }

}
