package com.ezra.elevatorapi.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ElevatorResponse {
    
    /*
     * Custom API response structure
     */
    private boolean status;
    private String message;
    private Object body;

    /* 
     * Constructing the response body
     */
    public ElevatorResponse(boolean status, String message, Object body){
        this.status = status;
        this.message = message;
        this.body = body;
    }
}
