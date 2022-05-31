package com.rabbitmq.studies.producer.amqp.impl;

import com.rabbitmq.studies.producer.amqp.AmqpProducer;
import com.rabbitmq.studies.producer.dto.Message;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProducerRabbitMq implements AmqpProducer<Message> {

    @Autowired
    private RabbitTemplate template;

    @Value("${spring.rabbitmq.request.routing-key.producer}")
    private String queue;
    @Value("${spring.rabbitmq.request.exchange.producer}")
    private String exchange;

    @Override
    public void producer(Message message) {
        try {
            template.convertAndSend(exchange, queue, message);
        } catch (Exception ex) {
            throw new AmqpRejectAndDontRequeueException(ex);
        }
    }

}
