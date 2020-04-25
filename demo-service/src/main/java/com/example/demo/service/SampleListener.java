package com.example.demo.service;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class SampleListener {

    private Messaging messaging;

    public SampleListener(Messaging messaging) {
        this.messaging = messaging;
    }

    @StreamListener(Messaging.REQUEST_CHANNEL)
    public void receiveRequestAndReply(String message) {
        System.out.println("received message : " + message);
        String responseMessage = "Response from service for : " + message;
        messaging.responseChannel().send(MessageBuilder.withPayload(responseMessage).build());
    }
}
