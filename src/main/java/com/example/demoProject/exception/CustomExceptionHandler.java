package com.example.demoProject.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.example.demoProject.model.pojo.ErrorMessage;
import com.example.demoProject.model.pojo.ErrorMessageGateway;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorMessage>> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<ErrorMessage> errorMessages = ex.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> new ErrorMessage(fieldError.getField(), fieldError.getDefaultMessage()))
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
    }
    
    @ExceptionHandler(CustomExceptionEmail.class)
    public ResponseEntity<ErrorMessage> customExceptionEmail(CustomExceptionEmail ex) {    	
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessage("Email", ex.getMessage()));

    }

    @ExceptionHandler(CustomExceptionGateway.class)
    public ResponseEntity<ErrorMessageGateway> customExceptionGateway(CustomExceptionGateway ex) {    	
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessageGateway(ex.getMessage()));
    	
    }
    
    @ExceptionHandler(WebClientResponseException.class)
    public ResponseEntity<ErrorMessageGateway> customExceptionGateway(WebClientResponseException ex) {    	
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessageGateway(ex.getMessage()));
    	
    }
}