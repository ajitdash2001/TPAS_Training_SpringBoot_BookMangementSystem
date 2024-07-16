package com.gl.app.exception;

import org.springframework.http.HttpStatus;

public class BMSApiException extends  RuntimeException{
    private HttpStatus httpStatus;
    private String message;

    public BMSApiException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
