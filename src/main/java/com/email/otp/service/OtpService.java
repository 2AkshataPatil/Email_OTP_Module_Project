package com.email.otp.service;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.email.otp.entity.OtpCode;
import com.email.otp.reposetory.OtpCodeRepository;

@Service
public class OtpService {

   @Autowired
   private OtpCodeRepository otpCodeRepository;


    public void generateOtp(String email) {
        String otpCode = generateOtpCode();
        OtpCode otp = new OtpCode(email, otpCode, LocalDateTime.now().plusMinutes(10));
        otpCodeRepository.save(otp);

        sendOtpEmail(email, otpCode);
    }

    public boolean validateOtp(String email, String code) {

        OtpCode otp = otpCodeRepository.findByEmail(email);

        if (otp != null && otp.getClass().equals(code) && otp.getExpiryDateTime().isAfter(LocalDateTime.now())) {

            return true;
        }

        return false;
    }

    private String generateOtpCode() {
      
        Random random = new Random();
        int otp = 100000 + random.nextInt(1000000);
        return String.valueOf(otp);
    }

    private void sendOtpEmail(String email, String otpCode) {
       
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject("OTP Verification");
            message.setTo("Your OTP code is: " + otpCode);

    }
}

