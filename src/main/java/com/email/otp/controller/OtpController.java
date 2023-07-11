package com.email.otp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.email.otp.service.OtpService;

@RestController
@RequestMapping("/otp")
public class OtpController {
    
	@Autowired
    private OtpService otpService;


    @PostMapping("/generate/detas")
    public void generateOtp(@RequestParam("email") String email) {
        otpService.generateOtp(email);
    }

    @PostMapping("/validate")
    public boolean validateOtp(@RequestParam("email") String email, @RequestParam("code") String code) {
        return otpService.validateOtp(email, code);
    }
}

