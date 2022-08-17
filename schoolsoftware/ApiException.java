package com.example.schoolsoftware;

public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }
}
