package com.kk.coading.ScenarioBasedApplication.exception;

public class ResourceNotFoundException extends RuntimeException{

    public  ResourceNotFoundException(String message){
        super(message);
    }
}
