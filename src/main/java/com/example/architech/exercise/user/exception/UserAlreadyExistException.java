package com.example.architech.exercise.user.exception;

public class UserAlreadyExistException extends IllegalArgumentException{
    public UserAlreadyExistException(String message){
        super(message);
    }
}
