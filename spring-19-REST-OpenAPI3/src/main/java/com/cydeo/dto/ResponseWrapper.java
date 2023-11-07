package com.cydeo.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Builder
@Data
public class ResponseWrapper {
    private String message;
    private HttpStatus status;
    private int statusCode;
    private Object data;
}
