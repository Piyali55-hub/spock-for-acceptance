package com.example.spock.demo.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublishMessageController {

    private RabbitTemplate rabbitTemplate;

    public PublishMessageController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/sendMessage")
    public void sendMessage(@RequestParam String exchange,
                            @RequestParam String routingKey,
                            @RequestBody String message) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }

    @GetMapping("/receiveMessage")
    public Object listenToQueue(@RequestParam String queue) {
        return rabbitTemplate.receiveAndConvert(queue, 10);
    }
}
