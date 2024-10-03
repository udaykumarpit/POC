package com.routes.service_a;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ServiceAApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServiceAApplication.class, args);
	}

	@GetMapping("/service-a/greet")
	@RateLimiter(name = "serviceA")
	public String greet() {
		return "Hello from Service A!";
	}
}
