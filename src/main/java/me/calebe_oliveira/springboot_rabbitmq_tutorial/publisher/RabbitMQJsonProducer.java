package me.calebe_oliveira.springboot_rabbitmq_tutorial.publisher;

import lombok.extern.slf4j.Slf4j;
import me.calebe_oliveira.springboot_rabbitmq_tutorial.dto.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQJsonProducer {
    private final String exchange;
    private final String routingJsonKey;
    private final RabbitTemplate rabbitTemplate;


    public RabbitMQJsonProducer(@Value("${rabbitmq.exchange.name}") String exchange,
                                @Value("${rabbitmq.routing.json.key}") String routingJsonKey,
                                RabbitTemplate rabbitTemplate) {
        this.exchange = exchange;
        this.routingJsonKey = routingJsonKey;
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendJsonMessage(User user) {
        log.info(String.format("Json message sent -> %s", user.toString()));
        rabbitTemplate.convertAndSend(exchange, routingJsonKey, user);
    }
}
