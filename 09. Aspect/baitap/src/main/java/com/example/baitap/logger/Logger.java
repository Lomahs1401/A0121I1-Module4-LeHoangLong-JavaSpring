package com.example.baitap.logger;

import com.example.baitap.exception.InvalidCode;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logger {
    @After("execution(public * com.example.baitap.repository..*(..))")
    public void checkLogger(JoinPoint joinPoint) {
        String nameClass = joinPoint.getTarget().getClass().getSimpleName();
        String nameMethod = joinPoint.getSignature().getName();
        System.out.println("Function " + nameMethod + " at class: " + nameClass);
    }

    @AfterThrowing(value = "execution(public * com.example.baitap.repository..*(..))", throwing = "invalidCode")
    public void loggerException(JoinPoint joinPoint, InvalidCode invalidCode) {
        String nameClass = joinPoint.getTarget().getClass().getName();
        String nameMethod = joinPoint.getSignature().getName();
        System.out.println("Function " + nameMethod + " at class: " + nameClass);
        System.out.println("Exception Message: " + invalidCode.getMessage());
    }
}
