package com.altoros.pcfdemo.handler;


import com.altoros.pcfdemo.model.Message;
import com.altoros.pcfdemo.repository.MessageRepository;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = {"ukQueue"})
public class MessageHandler {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageHandler(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @RabbitHandler
    public void onReceive(@Payload String message) {
        Message msg = new Message();
        msg.setText(message);
        messageRepository.save(msg);
    }
}
