package com.email.otp.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OtpCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String code;
    private LocalDateTime expiryDateTime;

    public OtpCode() {
    }

    public OtpCode(String email, String code, LocalDateTime expiryDateTime) {
        this.email = email;
        this.code = code;
        this.expiryDateTime = expiryDateTime;
    }

	public LocalDateTime getExpiryDateTime() {
		
		return null;
	}

}

