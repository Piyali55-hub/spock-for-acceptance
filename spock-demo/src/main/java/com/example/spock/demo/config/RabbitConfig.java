package com.example.spock.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class RabbitConfig {

    @Autowired
    private Environment environment;

    @Bean
    Queue queue() {
        return new Queue("response-queue");
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("response-exchange");
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(environment.getProperty("STORE_ID"));
    }
}
