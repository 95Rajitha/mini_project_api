package com.example.demo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * builder method for response entity to handle exceptions
     * @param apiExceptionModel
     * @return Response entity for Exception
     */
    private ResponseEntity<Object> buildResponseEntity( ApiExceptionModel apiExceptionModel )
    {
        return  new ResponseEntity<>(apiExceptionModel, apiExceptionModel.getHttpStatus());
    }


    /**
     * global handler for empty list exceptions
     * @param exception
     * @return Response Entity
     */
    @ExceptionHandler({EmptyListException.class})
    private ResponseEntity<Object> handleEmptyListException(EmptyListException exception){

        return  buildResponseEntity(new ApiExceptionModel(HttpStatus.EXPECTATION_FAILED, exception.getMessage(), exception));
    }

    /**
     * global handler for empty object exception
     * @param exception
     * @return ResponseEntity
     */
    @ExceptionHandler( { EmptyObjectException.class } )
    private ResponseEntity<Object> handleEmptyObjectException(EmptyObjectException exception){

        return  buildResponseEntity(new ApiExceptionModel(HttpStatus.BAD_REQUEST, exception.getMessage(),exception));
    }
}
