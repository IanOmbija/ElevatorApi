package com.ezra.elevatorapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ezra.elevatorapi.model.Elevator;
import com.ezra.elevatorapi.model.Floor;

@Repository
public interface ElevatorRepository extends JpaRepository<Elevator, Long> {
    
}
