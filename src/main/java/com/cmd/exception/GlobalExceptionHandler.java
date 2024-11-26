package com.cmd.exception;

import com.cmd.payload.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ErrorDetails> handleEmployeeNotFoundException
            (ResourceNotFound e, WebRequest request) {
        ErrorDetails details = new ErrorDetails(new Date(), e.getMessage(), request.getDescription(true)
        );

        return new ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

