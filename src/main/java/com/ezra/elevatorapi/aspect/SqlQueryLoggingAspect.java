package com.ezra.elevatorapi.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.support.SecurityContextProvider;
import org.springframework.stereotype.Component;

import com.ezra.elevatorapi.service.EventLogService;

@Aspect
@Component
public class SqlQueryLoggingAspect {

    private final EventLogService eventLogService;

    public SqlQueryLoggingAspect(EventLogService eventLogService){
        this.eventLogService = eventLogService;
    }

    @Pointcut("execution(* org.springframework.jdbc.core.JdbcTemplate.*(..))")
    public void jdbcTemplateMethods() {}

    @Before("jdbcTemplateMethods()")
    public void logSqlQuery(JoinPoint joinPoint){
        String query = (String) joinPoint.getArgs()[0];
        String source = joinPoint.getTarget().getClass().getSimpleName();
        eventLogService.logSqlQuery(query, source);
    }
    
}
