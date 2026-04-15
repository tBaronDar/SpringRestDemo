package com.tBaronDar.RestDemo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class PerformanceMonitorAspect {
    private final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitorAspect.class);

    @Around("execution(* com.tBaronDar.RestDemo.controller.JobRestController.getPost(..))")
    public Object monitorTime(ProceedingJoinPoint jp) throws Throwable {

        long start = System.currentTimeMillis();

        //signify what is before and what is after
        //by declaring when to run the Join Point method
        Object obj = jp.proceed();

        long end = System.currentTimeMillis();

        LOGGER.info("Time taken: " + (end - start) + " ms");

        //Must return the Object for the method to complete execution
        return obj;
    }
}
