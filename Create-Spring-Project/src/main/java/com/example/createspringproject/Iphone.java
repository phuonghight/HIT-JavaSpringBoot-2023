package com.example.createspringproject;

import org.springframework.stereotype.Component;

@Component("Iphone")
public class Iphone implements  Phone {
    @Override
    public void using() {
        System.out.println("Dang su dung iphone");
    }
}
