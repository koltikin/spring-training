package com.cydeo.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseWrapper {
    private boolean success;
    private String message;
    private HttpStatus status;
    private Integer statusCode;
    private Object data;

    public ResponseWrapper(String message, Object data) {
        this.success = true;
        this.status = HttpStatus.ACCEPTED;
        this.statusCode = HttpStatus.ACCEPTED.value();
        this.message = message;
        this.data = data;
    }

    public ResponseWrapper(String message) {
        this.success = true;
        this.message = message;
        this.status = HttpStatus.OK;
        this.statusCode = HttpStatus.OK.value();
    }
}
