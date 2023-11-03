package com.cydeo.dto;

import org.springframework.http.HttpStatus;

import java.net.http.HttpResponse;

public class ResponseWrapper {
    private boolean success;
    private String message;
    private Integer statusCode;
    private Object data;

    public ResponseWrapper(String message, Object data) {
        this.message = message;
        this.data = data;
        this.statusCode = HttpStatus.OK.value();
        this.success = true;
    }

    public ResponseWrapper(String message) {
        this.message = message;
        this.statusCode = HttpStatus.OK.value();
        this.success = true;
    }

}
