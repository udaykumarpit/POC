package com.example.OTP.controller;

import com.example.OTP.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/otp")
public class OtpController {

    @Autowired
    private OtpService otpService;

    @PostMapping("/generate/{phoneNumber}")
    public String generateOtp(@PathVariable String phoneNumber) {
        return otpService.generateOtp(phoneNumber);
    }

    @PostMapping("/validate/{phoneNumber}")
    public String validateOtp(@PathVariable String phoneNumber, @RequestParam String otp) {
        return otpService.validateOtp(phoneNumber, otp);
    }
}
