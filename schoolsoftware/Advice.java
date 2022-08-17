package com.example.schoolsoftware;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Advice {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Api> methodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        String message = methodArgumentNotValidException.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(new Api(message,400));
    }
    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<Api> apiException(Api api) {
        String message = api.getMessage();
        return ResponseEntity.status(400).body(new Api(message, 400));
    }
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Api> exception(Exception exception) {
        exception.printStackTrace();
        return ResponseEntity.status(500).body(new Api("SERVER ERROR !", 500));
    }
}
