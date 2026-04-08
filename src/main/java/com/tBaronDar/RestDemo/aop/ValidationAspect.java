package com.tBaronDar.RestDemo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {
    private final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* com.tBaronDar.RestDemo.JobRestController.getPost(..)) && args(postId)")
    public Object validate(ProceedingJoinPoint jp,int postId) throws Throwable {

        //check if post id is negative and make it positive
        if (postId<0){
            LOGGER.info("postId is negative, updating postId...");
            postId = -postId;
            LOGGER.info("postId new value is {}", postId);
        }
        //proceed with the method and add the new postId
        Object obj = jp.proceed(new Object[]{postId});
        return obj;
    }
}
