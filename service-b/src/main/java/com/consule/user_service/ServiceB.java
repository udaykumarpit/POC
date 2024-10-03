package com.consule.user_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ServiceB {

	public static void main(String[] args) {
		SpringApplication.run(ServiceB.class, args);
	}

	@RestController
	public static class ServiceBController {
		@GetMapping("/serviceB")
		public String serviceBEndpoint() {
			return "Hello from Service B!";
		}
	}
}

