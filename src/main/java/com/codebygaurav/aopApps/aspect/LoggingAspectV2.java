package com.codebygaurav.aopApps.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspectV2 {

    @Before("allServiceMethodPointcut()")
    public void beforeServiceMethod(JoinPoint joinPoint){
        log.info("Before advice method call, {}", joinPoint.getSignature());
    }

//    @After("allServiceMethodPointcut()")
    @AfterReturning(value = "allServiceMethodPointcut()", returning = "returnObj")
    public void afterServiceMethod(JoinPoint joinPoint, Object returnObj){
        log.info("After returning advice method call, {}", joinPoint.getSignature());
        log.info("After returning advice return value, {}", returnObj);
    }

    @AfterThrowing(value = "allServiceMethodPointcut()")
    public void afterServiceMethod(JoinPoint joinPoint){
        log.info("After throwing advice method call, {}", joinPoint.getSignature());
    }

    @Around("allServiceMethodPointcut()")
    public Object logExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        Long startTime = System.currentTimeMillis();
        Object returnedValue = proceedingJoinPoint.proceed();
        Long endTime = System.currentTimeMillis();

        Long diff = endTime-startTime;
        log.info("time taken for {} is {}", proceedingJoinPoint.getSignature(),diff);
        return returnedValue;
    }

    @Pointcut("execution( * com.codebygaurav.aopApps.services.impl.*.*(..))")
    public void allServiceMethodPointcut(){

    }

}
