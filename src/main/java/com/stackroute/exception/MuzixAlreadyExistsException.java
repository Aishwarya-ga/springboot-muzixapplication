package com.stackroute.exception;

public class MuzixAlreadyExistsException extends Exception{
    private String message;
    public MuzixAlreadyExistsException(){

    }
    public MuzixAlreadyExistsException(String message){
        super(message);
        this.message = message;
    }

}
