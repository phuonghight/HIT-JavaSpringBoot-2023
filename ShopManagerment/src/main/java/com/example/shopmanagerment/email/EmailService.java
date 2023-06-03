package com.example.shopmanagerment.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

@Service
public class EmailService implements EmailSender {
    @Autowired
    private JavaMailSender javaMailSender;

    private final static Logger log = LoggerFactory.getLogger(EmailService.class);


    @Override
    public String sendMail(String to, String subject, String content) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, StandardCharsets.UTF_8.name());
        messageHelper.setSubject(subject);
        messageHelper.setFrom("hoangphuong270703@gmail.com");
        messageHelper.setTo(to);
        messageHelper.setText(content, true);
        javaMailSender.send(message);
        return "Sent successfully";
    }
}
