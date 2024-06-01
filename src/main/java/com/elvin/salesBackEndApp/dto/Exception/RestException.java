package com.elvin.salesBackEndApp.dto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class RestException extends ResponseStatusException {

    private RestException(HttpStatus status, String reason) {
        super(status, reason);
    }

    public static RestException shopAlreadyRegistered() {
        return new RestException(HttpStatus.BAD_REQUEST, "Shop already registered");
    }

    public static RestException shopNotFound() {
        return new RestException(HttpStatus.NOT_FOUND, "Shop not found");
    }

    public static RestException orderNotFound() {
        return new RestException(HttpStatus.NOT_FOUND, "Order not found");    
    }
    
    public static RestException itemNotFound() {
        return new RestException(HttpStatus.NOT_FOUND, "Item not found");
    }

    public static RestException customException(HttpStatus status, String message) {
        return new RestException(status, message);
    }

    

}
