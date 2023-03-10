package com.example.createspringproject;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CreateSpringProjectApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(CreateSpringProjectApplication.class, args);
        User user = context.getBean(User.class);
        user.getPhone();
    }
}
