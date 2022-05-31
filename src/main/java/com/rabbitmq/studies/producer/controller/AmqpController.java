package com.rabbitmq.studies.producer.controller;

import com.rabbitmq.studies.producer.dto.Message;
import com.rabbitmq.studies.producer.service.AmqpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AmqpController {

    @Autowired
    private AmqpService service;

    @PostMapping("/send")
    public void sendToConsumer(@RequestBody Message message){
        service.sendToConsumer(message);
    }
}
