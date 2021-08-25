package com.vaccine.locator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AlreadyVaccinatedException extends RuntimeException{

    public AlreadyVaccinatedException(String exception) {
        super(exception);
    }
}
