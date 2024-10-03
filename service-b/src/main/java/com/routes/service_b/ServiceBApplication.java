package com.routes.service_b;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@SpringBootApplication
@RestController
public class ServiceBApplication {

	// Create a bucket that allows 5 requests per minute
	private final Bucket bucket;

	//capacity = means the bucket can hold a maximum of 5 tokens at any given time. This is the capacity of the bucket.
	//tokens = means that the bucket will attempt to add 20 tokens every minute.
	public ServiceBApplication() {
		Bandwidth limit = Bandwidth.classic(5, Refill.greedy(5, Duration.ofMinutes(1)));
		this.bucket = Bucket4j.builder().addLimit(limit).build();
	}

	public static void main(String[] args) {
		SpringApplication.run(ServiceBApplication.class, args);
	}

	@GetMapping("/service-b/farewell")
	public ResponseEntity<String> farewell() {
		// Check if the bucket has enough tokens (requests left)
		if (bucket.tryConsume(1)) {
			return ResponseEntity.ok("Goodbye from Service B!");
		} else {
			// If the rate limit is exceeded, return a 429 response
			return ResponseEntity.status(429).body("Too Many Requests - Try again later");
		}
	}
}
