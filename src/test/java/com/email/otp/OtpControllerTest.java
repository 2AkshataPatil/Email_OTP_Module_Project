package com.email.otp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.email.otp.controller.OtpController;
import com.email.otp.service.OtpService;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class OtpControllerTest {

    @Mock
    private OtpService otpService;

    @InjectMocks
    private OtpController otpController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGenerateOtp() {
        String email = "test@example.com";

        otpController.generateOtp(email);

        verify(otpService, times(1)).generateOtp(email);
    }

    @Test
    void testValidateOtp() {
        String email = "test@example.com";
        String code = "123456";

        when(otpService.validateOtp(email, code)).thenReturn(true);

        boolean result = otpController.validateOtp(email, code);

        assertTrue(result);
        verify(otpService, times(1)).validateOtp(email, code);
    }
}
