package com.superheroes.superheroes_test.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.superheroes.superheroes_test.exceptions.CustomException;
import com.superheroes.superheroes_test.responses.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> handleCustomException(CustomException ex) {
        
        String errorMessage = "Error: " + ex.getMessage();
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        ErrorResponse errorResponse = new ErrorResponse(errorMessage, httpStatus.value());

        return new ResponseEntity<>(errorResponse, httpStatus);
    }
}
