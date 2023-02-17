package com.ezra.elevatorapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ezra.elevatorapi.model.ElevatorEvent;
@Repository
public interface ElevatorEventRepository extends JpaRepository<ElevatorEvent, Long> {
    
}
