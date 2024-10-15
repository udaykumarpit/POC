package com.example.OTP.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;
@Service
public class OtpService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private final Random random = new Random();

    // Generate OTP
    public String generateOtp(String phoneNumber) {
        String otp = String.valueOf(100000 + random.nextInt(900000)); // Generate 6-digit OTP
        cacheOtp(phoneNumber, otp);
        return "OTP generated successfully. OTP is: " + otp;
    }

    // Cache OTP in Redis
    public void cacheOtp(String phoneNumber, String otp) {
        redisTemplate.opsForValue().set(phoneNumber, otp, 1, TimeUnit.MINUTES); // Set 1-minute expiration
    }

    // Validate OTP and return meaningful message
    public String validateOtp(String phoneNumber, String otp) {
        String cachedOtp = redisTemplate.opsForValue().get(phoneNumber);

        if (cachedOtp == null) {
            return "OTP has expired or is invalid.";
        }

        if (cachedOtp.equals(otp)) {
            // Evict the OTP after successful validation
            redisTemplate.delete(phoneNumber);
            return "OTP validated successfully.";
        } else {
            return "Invalid OTP. Please try again.";
        }
    }
}
