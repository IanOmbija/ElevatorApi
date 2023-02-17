package com.ezra.elevatorapi.exception;

public class ElevatorOccupiedException  extends RuntimeException{
    public ElevatorOccupiedException(){

    }

    public ElevatorOccupiedException(String message){
        super(message);
    }

    public ElevatorOccupiedException(String message, Throwable cause){
        super(message,cause);
    }

    public ElevatorOccupiedException(Throwable cause){
        super(cause);
    }

    public ElevatorOccupiedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message,cause,enableSuppression,writableStackTrace);
    }
    
}
