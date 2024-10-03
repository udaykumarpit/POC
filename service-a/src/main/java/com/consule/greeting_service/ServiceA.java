package com.consule.greeting_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class ServiceA {

	public static void main(String[] args) {
		SpringApplication.run(ServiceA.class, args);
	}

	@Bean
	@LoadBalanced // Enables load balancing for RestTemplate
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@RestController
	public static class ServiceAController {
		@Autowired
		private RestTemplate restTemplate;

		@GetMapping("/serviceA")
		public String serviceAEndpoint() {
			String serviceBResponse = restTemplate.getForObject("http://service-b/serviceB", String.class);
			return "Hello from Service A! Calling Service B says: " + serviceBResponse;
		}
	}
}
