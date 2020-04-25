package com.example.spock.demo

import org.springframework.web.client.RestTemplate
import spock.lang.Specification

import static org.assertj.core.api.AssertionsForClassTypes.assertThat

class GreetingTest extends Specification {

    def "should hit greeting"() {
        given: "A restTemplate"
        RestTemplate restTemplate = new RestTemplate()

        when: "making API call"
        String respose = restTemplate.getForEntity("http://localhost:9500/greeting", String.class).getBody()

        then: "should get response"
        assertThat(respose).isEqualTo("Hello World!");
    }

}
