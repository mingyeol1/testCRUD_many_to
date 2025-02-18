package com.crud.test.mail;

public interface EmailService {



    String generateVerificationCode();

    void sendVerificationEmail(String recipientEmail, String code);

}
