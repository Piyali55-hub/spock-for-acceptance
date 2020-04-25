package com.example.demo.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Messaging {

    String REQUEST_CHANNEL = "request-channel";
    String RESPONSE_CHANNEL = "response-channel";

    @Input(REQUEST_CHANNEL)
    SubscribableChannel requestChannel();

    @Output(RESPONSE_CHANNEL)
    MessageChannel responseChannel();
}
