package com.tBaronDar.RestDemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    //return type -- fully qualified class name.method name(args) OR * for all .. for all args

    //all return types--all classes.allMethods(with all args)

    @Before("execution(* com.tBaronDar.RestDemo.service.JobService.*(..))")
    public void logMethodCall(){
        LOGGER.info("Method called");
    }

    //use || to add multiple execution()
    //"execution(* com.tBaronDar.RestDemo.controller.JobRestController.getAllPosts(..)) || execution(* com.tBaronDar.RestDemo.controller.JobRestController.getPost(..))"
    @Before("execution(* com.tBaronDar.RestDemo.controller.JobRestController.getAllPosts(..))")
    public void logControllerMethodCall(JoinPoint jp){
        LOGGER.info("Before Controller Method called "+ jp.getSignature().getName());
    }

    @After("execution(* com.tBaronDar.RestDemo.controller.JobRestController.getPost(..))")
    public void logAfterControllerMethodCall(JoinPoint jp){
        LOGGER.info("Controller 22 Method called "+ jp.getSignature().getName());
    }
}
