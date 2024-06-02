package me.calebe_oliveira.springboot_rabbitmq_tutorial.publisher;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQProducer {
    private final String exchange;
    private final String routingKey;
    private final RabbitTemplate rabbitTemplate;

    public RabbitMQProducer(@Value("${rabbitmq.exchange.name}") String exchange,
                            @Value("${rabbitmq.routing.key}") String routingKey,
                            RabbitTemplate rabbitTemplate) {
        this.exchange = exchange;
        this.routingKey = routingKey;
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message) {
        log.info(String.format("Message sent -> %s", message));
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }
}
