package com.elvin.salesBackEndApp.dto.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class RestException extends ResponseStatusException {

    private RestException(HttpStatus status, String reason) {
        super(status, reason);
    }

    public static RestException shopAlreadyRegistered() {
        return new RestException(HttpStatus.BAD_REQUEST, "Shop already registered");
    }

}
