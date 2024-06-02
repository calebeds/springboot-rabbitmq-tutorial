package me.calebe_oliveira.springboot_rabbitmq_tutorial.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    private final String queue;
    private final String exchange;
    private final String routingKey;

    public RabbitMQConfig(@Value("${rabbitmq.queue.name}") String queue,
                          @Value("${rabbitmq.exchange.name}") String exchange,
                          @Value("${rabbitmq.routing.key}") String routingKey) {
        this.queue = queue;
        this.exchange = exchange;
        this.routingKey = routingKey;
    }

    // spring bean for rabbitmq queue
    @Bean
    public Queue queue() {
        return new Queue(queue);
    }

    // spring bean for rabbitmq exchange
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(exchange);
    }

    // binding between queue and exchange using routing key
    @Bean
    public Binding binding() {
        return BindingBuilder
                .bind(queue())
                .to(exchange())
                .with(routingKey);
    }

    // Connection Factory
    // Rabbit Template
    // Rabbit Admin
}
