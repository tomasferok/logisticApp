package com.iLogApp.logisticApp.com.exceptions;

public class InvalidProductCategoryException extends RuntimeException{
    public InvalidProductCategoryException(String message){
        super(message);
    }
}
