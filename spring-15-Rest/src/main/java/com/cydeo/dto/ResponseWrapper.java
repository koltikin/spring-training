package com.cydeo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;


@NoArgsConstructor
@Getter
@Setter
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
