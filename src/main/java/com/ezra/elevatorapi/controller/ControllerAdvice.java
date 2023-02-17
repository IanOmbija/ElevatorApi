package com.ezra.elevatorapi.controller;

import com.ezra.elevatorapi.exception.ElevatorException;
import com.ezra.elevatorapi.exception.ElevatorOccupiedException;
import com.ezra.elevatorapi.exception.InvalidRequestException;
import com.ezra.elevatorapi.response.ElevatorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@org.springframework.web.bind.annotation.ControllerAdvice
@RestController
public class ControllerAdvice extends ResponseEntityExceptionHandler{
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
        Map<String, String> errors = new HashMap<>();
        for (FieldError error: ex.getBindingResult().getFieldErrors()){
            errors.put(error.getField(), error.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()){
            errors.put(error.getObjectName(), error.getDefaultMessage());
        }

        ElevatorResponse response = ElevatorResponse.builder().status(false).message("Invalid Data Supplied").body(errors).build();
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(ElevatorException.class)
    public ResponseEntity<Object> handleCustomErrors(Exception exception){
        ElevatorResponse response = ElevatorResponse.builder().status(false).message(exception.getMessage()).build();
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ElevatorOccupiedException.class)
    public ResponseEntity<Object> handleElevatorOccErrors(Exception exception){
        ElevatorResponse response = ElevatorResponse.builder().status(false).message(exception.getMessage()).build();
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<Object> handleInvalidRequestErrors(Exception exception){
        ElevatorResponse response = ElevatorResponse.builder().status(false).message(exception.getMessage()).build();
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }
    
}
