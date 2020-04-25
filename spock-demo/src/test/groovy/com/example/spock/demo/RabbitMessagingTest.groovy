package com.example.spock.demo

import org.springframework.web.client.RestTemplate
import spock.lang.Specification

import static org.assertj.core.api.AssertionsForClassTypes.assertThat

class RabbitMessagingTest extends Specification{

    def "should send a message and receive reply asynchronously" () {

        given: "a sample message with routing key and an exchange"
        String message = "Sample test message"
        String routingKey = "#"
        String exchange = "request-exchange"

        when: "message is published to request exchange"
        RestTemplate restTemplate = new RestTemplate()
        restTemplate.postForEntity("http://localhost:9500/sendMessage?exchange=" + exchange + "&routingKey=" + routingKey, message, Object.class)
        Thread.sleep(5)

        then: "should receive response from response queue"
        String queue = "response-queue"
        String response = restTemplate.getForEntity("http://localhost:9500/receiveMessage?queue=" + queue, String.class).getBody()
        String expectedResponse = "Response from service for : " + message
        assertThat(response).isEqualTo(expectedResponse)

    }
}
