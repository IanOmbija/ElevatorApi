package com.ezra.elevatorapi.controller;

import com.ezra.elevatorapi.dto.ElevatorStatusDTO;
import com.ezra.elevatorapi.model.*;
import com.ezra.elevatorapi.response.ElevatorResponse;
import com.ezra.elevatorapi.service.ElevatorService;
import com.ezra.elevatorapi.service.EventLogService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/elevator")
public class ElevatorController {

    private final ElevatorService elevatorService;
    private final EventLogService eventLogService;

    public ElevatorController(ElevatorService elevatorService, EventLogService eventLogService){
        this.elevatorService = elevatorService;
        this.eventLogService = eventLogService;
    }

    @PostMapping("/call/{elevatorId}")
    public ResponseEntity<ElevatorResponse> callElevator(@PathVariable("elevatorId")  Long elevatorId, @RequestParam (value = "toFloor", required = false) Integer toFloor){
        elevatorService.moveElevator(elevatorId, toFloor);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{elevatorId}/status")
    public ResponseEntity<ElevatorStatusDTO> getElevatorStatus(@PathVariable Long elevatorId){
        return ResponseEntity.ok(elevatorService.getElevatorStatus(elevatorId));
    }
    
}
