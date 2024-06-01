package com.elvin.salesBackEndApp.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import com.elvin.salesBackEndApp.dto.WebResponse;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ErrorHandlerController {
    
    @ExceptionHandler(Exception.class)
    public WebResponse<String> checkWhatExceptionIsCalled(Exception e) {
        return WebResponse.<String>builder()
        .errMessage(e.getMessage())
        .StatusCode(HttpStatusCode.valueOf(500))
        .build();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public WebResponse<String> constraintViolationException(ConstraintViolationException e) {
        return WebResponse.<String>builder()
        .errMessage(e.getMessage())
        .StatusCode(HttpStatusCode.valueOf(400))
        .build();
    }

    @ExceptionHandler(ResponseStatusException.class)
    public WebResponse<String> APIViolationExceptoin(ResponseStatusException e) {
        
        return WebResponse.<String>builder()
        .errMessage(e.getMessage())
        .StatusCode(e.getStatusCode())
        .build();
    }
}
