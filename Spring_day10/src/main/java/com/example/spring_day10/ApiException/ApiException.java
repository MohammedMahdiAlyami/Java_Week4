package com.example.spring_day10.ApiException;

public class ApiException extends RuntimeException{
    public ApiException(String massage) {
        super(massage);
    }
}
