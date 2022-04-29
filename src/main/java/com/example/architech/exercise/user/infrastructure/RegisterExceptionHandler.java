package com.example.architech.exercise.user.infrastructure;

import com.example.architech.exercise.user.exception.InvalidLoginException;
import com.example.architech.exercise.user.exception.InvalidPasswordException;
import com.example.architech.exercise.user.exception.UserErrorResponse;
import com.example.architech.exercise.user.exception.UserAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RegisterExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({UserAlreadyExistException.class, InvalidPasswordException.class, InvalidLoginException.class})
    public ResponseEntity<UserErrorResponse> userAlreadyExist(Exception ex, WebRequest request) {

        UserErrorResponse errors = new UserErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setError(ex.getMessage());
        errors.setStatus(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
