package com.stackroute.exception;

public class MuzixNotFoundException extends Exception {

    private String message;

    public MuzixNotFoundException() {
    }

    public MuzixNotFoundException(String message) {
        this.message = message;
    }
}
