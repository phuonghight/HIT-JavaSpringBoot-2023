package com.example.week_03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan(basePackages = "test")
@SpringBootApplication
public class Week03Application {
    public static void main(String[] args) {
        ApplicationContext contex = SpringApplication.run(Week03Application.class, args);
    }
}
