package com.email.otp.reposetory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.email.otp.entity.OtpCode;

@Repository
public interface OtpCodeRepository extends JpaRepository<OtpCode, Long> {

    OtpCode findByEmail(String email);
}

