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
public class AlreadyExistsException extends RuntimeException {
    private String message;
    private HttpStatus status;

    public AlreadyExistsException(String message) {
        this.message = message;
        this.status = HttpStatus.BAD_REQUEST;
    }
}
