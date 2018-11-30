package com.altoros.pcfdemo.controller;

import com.altoros.pcfdemo.model.Message;
import com.altoros.pcfdemo.repository.MessageRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {
    private final RabbitTemplate rabbitTemplate;
    private final MessageRepository messageRepository;

    @Autowired
    public MessageController(RabbitTemplate rabbitTemplate, MessageRepository messageRepository) {
        this.rabbitTemplate = rabbitTemplate;
        this.messageRepository = messageRepository;
    }

    @GetMapping("/publish")
    public HttpStatus publish(@RequestParam String message) {
        rabbitTemplate.convertAndSend("ukQueue", message);
        return HttpStatus.OK;
    }

    @GetMapping("/messages")
    public List<Message> messages(){
        return messageRepository.findAll();
    }


    @GetMapping("/vcap")
    public String vcap() {
        return System.getenv("VCAP_SERVICES");
    }

}
