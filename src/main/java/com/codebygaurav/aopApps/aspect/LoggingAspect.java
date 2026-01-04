package com.codebygaurav.aopApps.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

//    @Before("execution(* com.codebygaurav.aopApps.services.impl.ShipmentServiceImpl.*(..))")
    @Before("execution(* com.codebygaurav.aopApps.services.impl.*.*(..))")
    public void beforeShipmentServiceMethods(JoinPoint joinPoint) {
        log.info("Before called from lo LoggingAspect kind, {}", joinPoint.getKind());
        log.info("Before called from lo LoggingAspect Signature, {}", joinPoint.getSignature());
    }

    @After("myLoggingAndAopMethodsPointCut()")
    public void afterTransactionalAnnotationCalls(){
        log.info("After MyLogging annotation calls");
    }

    @Before("within(com.codebygaurav.aopApps..*)")
    public void beforeShipmentServiceMethods(){
        log.info("Service Impl calls");
    }

    @Before("myLoggingAndAopMethodsPointCut()")
    public void beforeTransactionalAnnotationCalls(){
        log.info("Before MyLogging annotation calls");
    }

    @Pointcut("@annotation(com.codebygaurav.aopApps.aspect.MyLogging) && within(com.codebygaurav.aopApps..*)")
    public void myLoggingAndAopMethodsPointCut(){

    }

}
