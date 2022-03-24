package com.example.demo.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ApiExceptionModel {

    private HttpStatus httpStatus;

    private LocalDateTime timestamp;

    private String message;

    private Object messageObject;

    private ApiExceptionModel()
    {
        timestamp = LocalDateTime.now();
    }

    /**
     * apiExcetion model constructor chain
     * @param httpStatus
     * @param exception
     */
    ApiExceptionModel( HttpStatus httpStatus, Throwable exception )
    {
        this();
        this.httpStatus = httpStatus;
        this.message = "Unexpected error";
    }

    /**
     * apiExcetion model constructor chain
     * @param httpStatus
     * @param message
     * @param exception
     */
    ApiExceptionModel( HttpStatus httpStatus, String message, Throwable exception )
    {
        this();
        this.httpStatus = httpStatus;
        this.message = message;
    }

}
