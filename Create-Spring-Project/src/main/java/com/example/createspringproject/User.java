package com.example.createspringproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class User {

    @Autowired
    @Qualifier("Samsung")
    private Phone phone;

    public void getPhone() {
        this.phone.using();
    }
}
