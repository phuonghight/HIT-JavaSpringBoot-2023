package com.example.shopmanagerment.controller;

import com.example.shopmanagerment.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EmailController {
    @Autowired
    private EmailService emailService;
}
