package com.iLogApp.logisticApp.com.exceptions;

public class InvalidOrderException extends RuntimeException{
    public InvalidOrderException(String message){
        super(message);
    }

}
