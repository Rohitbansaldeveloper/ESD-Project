package com.rohit.academics.exception;

import com.rohit.academics.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex) {
        ErrorResponse errorResponse=new ErrorResponse(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotAdmin.class)
    public ResponseEntity<ErrorResponse> handleUserNotAdmin(UserNotAdmin ex) {
        ErrorResponse errorResponse=new ErrorResponse(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(WrongPasswordException.class)
    public ResponseEntity<ErrorResponse> handleWrongPasswordException(WrongPasswordException ex) {
        ErrorResponse errorResponse=new ErrorResponse(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }


}
