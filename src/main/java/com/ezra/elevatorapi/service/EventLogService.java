package com.ezra.elevatorapi.service;
import org.springframework.stereotype.Service;

import com.ezra.elevatorapi.model.ElevatorEvent;
import com.ezra.elevatorapi.model.SqlQueryLog;
import com.ezra.elevatorapi.repository.ElevatorEventRepository;
import com.ezra.elevatorapi.repository.SqlLogRepository;

@Service
public class EventLogService {

    private final ElevatorEventRepository elevatorEventRepository;
    private final SqlLogRepository sqlLogRepository;

    public EventLogService(ElevatorEventRepository elevatorEventRepository, SqlLogRepository sqlLogRepository){
        this.elevatorEventRepository = elevatorEventRepository;
        this.sqlLogRepository = sqlLogRepository;
    }

    public void logElevatorEvent(Long elevatorId, Integer floor, String event){
        ElevatorEvent elevatorEvent = new ElevatorEvent();
        elevatorEvent.setId(elevatorId);
        elevatorEvent.setFloor(floor);
        elevatorEvent.setEvent(event);
        elevatorEventRepository.save(elevatorEvent);
    }

    public void logSqlQuery(String query, String source){
        SqlQueryLog sqlQueryLog = new SqlQueryLog();
        sqlQueryLog.setQuery(query);
        sqlQueryLog.setSource(source);
        sqlLogRepository.save(sqlQueryLog);


    }

    
}
