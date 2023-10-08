package com.superheroes.superheroes_test.aspects;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import com.superheroes.superheroes_test.annotations.ExecutionTimeLogger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
@Component
public class ExecutionTimeLoggerAspect {
    private static final Logger logger = LoggerFactory.getLogger(ExecutionTimeLoggerAspect.class);

    @Around("@annotation(executionTimeLogger)")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint, ExecutionTimeLogger executionTimeLogger) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        String methodName = joinPoint.getSignature().toShortString();
        String customMessage = executionTimeLogger.value();

        logger.info("{} executed in {} ms. {}", methodName, executionTime, customMessage);

        return result;
    }
}
