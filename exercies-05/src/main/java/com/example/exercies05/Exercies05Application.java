package com.example.exercies05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Exercies05Application {
    public static void main(String[] args) {
        SpringApplication.run(Exercies05Application.class, args);
    }
}
