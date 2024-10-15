package com.example.OTP.controller;


import com.example.OTP.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/otp")
public class OtpController {

    @Autowired
    private OtpService otpService;

    @PostMapping("/generate")
    public String generateOtp(@RequestParam String phoneNumber) {
        String otp = otpService.generateOtp(phoneNumber);
        return "OTP for " + phoneNumber + ": " + otp;
    }

    @GetMapping("/validate")
    public String validateOtp(@RequestParam String phoneNumber, @RequestParam String otp) {
        boolean isValid = otpService.validateOtp(phoneNumber, otp);
        return isValid ? "OTP is valid" : "OTP is invalid or expired";
    }
}