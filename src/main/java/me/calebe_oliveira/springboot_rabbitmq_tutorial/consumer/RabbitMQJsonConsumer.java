package me.calebe_oliveira.springboot_rabbitmq_tutorial.consumer;

import lombok.extern.slf4j.Slf4j;
import me.calebe_oliveira.springboot_rabbitmq_tutorial.dto.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQJsonConsumer {
    @RabbitListener(queues = "${rabbitmq.queue.json.name}")
    public void consumerJsonMessage(User user) {
        log.info(String.format("Received Json Message -> %s", user.toString()));
    }
}
