package me.calebe_oliveira.springboot_rabbitmq_tutorial.controller;

import lombok.RequiredArgsConstructor;
import me.calebe_oliveira.springboot_rabbitmq_tutorial.dto.User;
import me.calebe_oliveira.springboot_rabbitmq_tutorial.publisher.RabbitMQJsonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MessageJsonController {
    private final RabbitMQJsonProducer jsonProducer;

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user) {
        jsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Json message sent to RabbitMQ ...");
    }
}
