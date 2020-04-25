package com.example.demo.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(Messaging.class)
public class DemoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoServiceApplication.class, args);
	}

}
