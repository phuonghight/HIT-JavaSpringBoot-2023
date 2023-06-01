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
public class InvalidException extends RuntimeException {
    private String message;
    private HttpStatus status;

    public InvalidException(String message) {
        this.message = message;
        this.status = HttpStatus.BAD_REQUEST;
    }
}
