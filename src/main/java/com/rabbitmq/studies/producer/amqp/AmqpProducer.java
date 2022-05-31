package com.rabbitmq.studies.producer.amqp;

public interface AmqpProducer<T> {
    void producer(T t);
}
