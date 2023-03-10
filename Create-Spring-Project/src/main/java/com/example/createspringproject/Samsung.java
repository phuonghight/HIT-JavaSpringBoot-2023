package com.example.createspringproject;

import org.springframework.stereotype.Component;

@Component("Samsung")
public class Samsung implements Phone {

    @Override
    public void using() {
        System.out.println("Dang su dung Samsung");
    }
}
