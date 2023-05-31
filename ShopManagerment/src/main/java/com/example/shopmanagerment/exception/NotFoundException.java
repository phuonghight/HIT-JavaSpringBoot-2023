package com.example.shopmanagerment.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotFoundException extends RuntimeException {
    private String message;
    private HttpStatus httpStatus;

    public NotFoundException(String message) {
        super(message);
        this.message = message;
        this.httpStatus = HttpStatus.NOT_FOUND;
    }
}
