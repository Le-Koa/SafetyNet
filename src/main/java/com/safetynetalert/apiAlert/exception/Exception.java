package com.safetynetalert.apiAlert.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class Exception extends  RuntimeException {

    public Exception(String message) {
        super(message);
    }
}
