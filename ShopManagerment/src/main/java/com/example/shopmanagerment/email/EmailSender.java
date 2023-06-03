package com.example.shopmanagerment.email;

import javax.mail.MessagingException;

public interface EmailSender {
    public String sendMail(String to, String subject, String content) throws MessagingException;
}
