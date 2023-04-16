package com.example.week04.Exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ErrorMessage notFoundHandler(NotFoundException ex, WebRequest request) {
        System.out.println(ex.getMessage());
        return new ErrorMessage(ex.getMessage(), ex.getStatus());
    }
}
