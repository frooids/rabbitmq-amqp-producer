package com.rabbitmq.studies.producer.service.impl;

import com.rabbitmq.studies.producer.amqp.AmqpProducer;
import com.rabbitmq.studies.producer.dto.Message;
import com.rabbitmq.studies.producer.service.AmqpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQServiceImpl implements AmqpService {

    @Autowired
    private AmqpProducer amqpProducer;

    @Override
    public void sendToConsumer(Message message) {
        amqpProducer.producer(message);
    }
}
