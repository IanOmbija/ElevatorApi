package com.ezra.elevatorapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ezra.elevatorapi.model.SqlQueryLog;
@Repository
public interface SqlLogRepository  extends JpaRepository <SqlQueryLog, Long>{
    
}
