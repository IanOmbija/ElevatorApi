package com.ezra.elevatorapi.service;

import com.ezra.elevatorapi.model.Elevator;
import com.ezra.elevatorapi.model.Floor;
import com.ezra.elevatorapi.repository.ElevatorRepository;
import com.ezra.elevatorapi.enums.Directions;
import com.ezra.elevatorapi.enums.Status;
import com.ezra.elevatorapi.exception.ElevatorException;
import com.ezra.elevatorapi.exception.InvalidRequestException;
import com.ezra.elevatorapi.dto.ElevatorStatusDTO;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ElevatorService {

    private final ElevatorRepository elevatorRepository;
    private final EventLogService eventLogService;

    public ElevatorService(ElevatorRepository elevatorRepository, EventLogService eventLogService){
        this.elevatorRepository = elevatorRepository;
        this.eventLogService = eventLogService;
    }

    public void moveElevator(Long elevatorId, Integer toFloor){
        Elevator elevator = elevatorRepository.findById(elevatorId).orElseThrow(() -> new ElevatorException("Elevator not found"));
        
        //We check if the elevator is currently moving
        if(elevator.getStatus() ==Status.MOVING){
          throw new ElevatorException("Elevator is currently occupied"); 
        }

        //check if already at the request floor
        if(elevator.getCurrentFloor() == toFloor){
            throw new InvalidRequestException("Elevator already at the requested floor");
        }

        //else we move it to the required floor
        Directions direction = elevator.getCurrentFloor() < toFloor ? Directions.UP : Directions.DOWN;
        elevator.setDirections(direction);
        elevator.setStatus(Status.MOVING);
        elevatorRepository.save(elevator);
        // we asynchronously now move the elevator to the req floor
        moveElevatorAsync(elevator, toFloor);
    
    }

    public ElevatorStatusDTO getElevatorStatus(Long elevatorId){
        Elevator elevator = elevatorRepository.findById(elevatorId).orElseThrow(() -> new ElevatorException("Elevator not found"));
        return new ElevatorStatusDTO(elevator.getCurrentFloor(), elevator.getStatus(), elevator.getDirections());
    }

    @Async
    public void moveElevatorAsync(Elevator elevator, Integer toFloor){
        int currentFloor = elevator.getCurrentFloor();
        int floorsToMove = Math.abs(currentFloor - toFloor);
        int totalSeconds = floorsToMove * 5 + 4;
        try{
            //we simulate the moving elevator
            for(int i = 0; i <totalSeconds; i++){
                Thread.sleep(1000);
                if (i == 2){
                    // open the doors
                    elevator.setStatus(Status.DOORS_OPEN);
                    elevatorRepository.save(elevator);
                }else if ( i == totalSeconds - 2){
                    // close the doors
                    elevator.setStatus(Status.IDLE);
                    elevator.setCurrentFloor(toFloor);
                    //logging the event
                    eventLogService.logElevatorEvent(elevator.getId(), toFloor, "Arrived");
                }else  if (i > 2 && i < totalSeconds - 2){
                    // moving to the next flr
                    int nextFloor = currentFloor + (elevator.getDirections() == Directions.UP ? 1 : -1);
                    elevator.setCurrentFloor(nextFloor);
                    elevatorRepository.save(elevator);
                    //logging the elevator event
                    eventLogService.logElevatorEvent(elevator.getId(), nextFloor, "Moving");
                    currentFloor = nextFloor;
                }
            }
        } catch (InterruptedException e){
            
        }
    }


    
}
