package com.vaccine.locator.exceptionhandler;

import com.vaccine.locator.exception.AlreadyVaccinatedException;
import com.vaccine.locator.exception.EntryNotFoundException;
import com.vaccine.locator.exception.InvalidAadharNumberException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(basePackages = "com.vaccine.locator")

@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    //logger
    private final Logger LOG = LoggerFactory.getLogger(getClass());
    //custom exception handler for Invalid Aadhar number
    @ExceptionHandler(value={InvalidAadharNumberException.class})
    public ResponseEntity<Object> handleInvalidAadharNumberException(Exception e, WebRequest request) {
        String errorMessage = e.getMessage();
        LOG.error(errorMessage);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    //custom exception handler for Entry Not found Exception
    @ExceptionHandler(value={EntryNotFoundException.class})
    public ResponseEntity<Object> handleEntryNotFoundException(Exception e, WebRequest request) {
        String errorMessage = e.getMessage();
        LOG.error(errorMessage);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
    //custom exception handler for Already vaccinated Exception
    @ExceptionHandler(value={AlreadyVaccinatedException.class})
    public ResponseEntity<Object> handleAlreadyVaccinatedException(Exception e, WebRequest request) {
        String errorMessage = e.getMessage();
        LOG.error(errorMessage);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }
}
