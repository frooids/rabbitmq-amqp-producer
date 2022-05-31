package com.rabbitmq.studies.producer.service;

import com.rabbitmq.studies.producer.dto.Message;

public interface AmqpService {
    void sendToConsumer(Message message);
}
