package com.example.OTP.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class OtpService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Value("${otp.expiration}")
    private long otpExpirationTime;

    private static final int OTP_LENGTH = 6;
    private Random random = new Random();

    // Generate OTP and store it in Redis with an expiration time
    public String generateOtp(String phoneNumber) {
        String otp = String.format("%06d", random.nextInt(999999));
        redisTemplate.opsForValue().set(phoneNumber, otp, otpExpirationTime, TimeUnit.SECONDS);
        return otp;
    }

    // Validate the OTP without deleting it
    public boolean validateOtp(String phoneNumber, String otp) {
        String storedOtp = redisTemplate.opsForValue().get(phoneNumber);

        if (storedOtp != null && storedOtp.equals(otp)) {
            return true;
        }
        return false;
    }
}