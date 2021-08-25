package com.vaccine.locator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidAadharNumberException extends RuntimeException{

    public InvalidAadharNumberException(String exception) {
        super(exception);
    }
}
