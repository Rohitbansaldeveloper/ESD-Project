package com.rohit.academics.dto;

public class ErrorResponse {
    private String message;

    public ErrorResponse( String message) {
//        this.errorCode = errorCode;
        this.message = message;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
