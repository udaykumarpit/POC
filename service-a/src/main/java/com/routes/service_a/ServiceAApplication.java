package com.routes.service_a;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ServiceAApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServiceAApplication.class, args);
	}

	@GetMapping("/service-a/greet")
	@RateLimiter(name = "serviceA", fallbackMethod = "rateLimitFallback")
	public String greet() {
		return "Hello from Service A!";
	}

	// Fallback method for Rate Limiter
	public ResponseEntity<String> rateLimitFallback(Exception e) {
		// Return a custom 429 response when the rate limit is exceeded
		return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
				.body("Too many requests - please try again later.");
	}
}
