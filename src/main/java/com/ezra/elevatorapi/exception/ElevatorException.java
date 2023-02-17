package com.ezra.elevatorapi.exception;

public class ElevatorException extends RuntimeException {

    public ElevatorException(){

    }

    public ElevatorException(String message){
        super(message);
    }

    public ElevatorException(String message, Throwable cause){
        super(message,cause);
    }

    public ElevatorException(Throwable cause){
        super(cause);
    }

    public ElevatorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message,cause,enableSuppression,writableStackTrace);
    }
    
}
