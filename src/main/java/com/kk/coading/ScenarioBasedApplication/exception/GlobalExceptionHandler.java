package com.kk.coading.ScenarioBasedApplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {


    public ResponseEntity<Object> handleNotFound(ResourceNotFoundException exception,
                                                 WebRequest webRequest){
        return  new ResponseEntity<>(Map.of(
                "timestamp", LocalDateTime.now(),
                "message", exception.getMessage(),
                "status", HttpStatus.INTERNAL_SERVER_ERROR.value()
        ), HttpStatus.INTERNAL_SERVER_ERROR);

    }

    public ResponseEntity<Object> handleAll(Exception exception, WebRequest webRequest){

        return  new ResponseEntity<>(Map.of(
                "timestamp", LocalDateTime.now(),
                "message", exception.getMessage(),
                "status", HttpStatus.INTERNAL_SERVER_ERROR.value()
        ), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
