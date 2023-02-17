package com.ezra.elevatorapi.model;

import lombok.Data;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ezra.elevatorapi.enums.Directions;
import com.ezra.elevatorapi.enums.Status;

@Entity
@Data
public class Elevator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer currentFloor;
    private Directions directions;
    private Status status;
    
}
