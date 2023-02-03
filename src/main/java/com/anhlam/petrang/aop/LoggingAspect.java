package com.anhlam.petrang.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.web.context.request.NativeWebRequest;

@Aspect
public class LoggingAspect {

    private final Environment env;

    public LoggingAspect(Environment env) {
        this.env = env;
    }

    @Pointcut("@annotation(com.anhlam.petrang.annotation.HandlingBusiness)")
    public void springBeanPointcut() {
        // Method is empty as this is just a Pointcut, the implementations are in the advices.
    }

    @Around("springBeanPointcut()")
    public Object handleHandlingBusinessWhenRunFunc(ProceedingJoinPoint joinPoint) throws Throwable {
        return joinPoint.proceed();
    }

    @Before("springBeanPointcut()")
    public Object beforeHandle(JoinPoint joinPoint) throws Throwable {
        try {
            Object result = joinPoint.getClass();
            return result;
        } catch (Throwable e) {
            throw e;
        }
    }

    @AfterReturning("springBeanPointcut()")
    public Object afterHandle(JoinPoint joinPoint) throws Throwable {
        try {
            Object result = joinPoint.getClass();
            return result;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}
