package com.ibotta.gradle.aop.java;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class JavaAspect {
//    @Before("execution(* demonstrateJavaAOP(..))")
//    public void before(JoinPoint joinPoint) {
//        MessageListener messageListener = (MessageListener) joinPoint.getArgs()[0];
//        messageListener.onMessage("Java AOP before hook triggered.", CallerType.BEFORE_HOOK);
//    }
//
//    @After("execution(* demonstrateJavaAOP(..))")
//    public void after(JoinPoint joinPoint) {
//        MessageListener messageListener = (MessageListener) joinPoint.getArgs()[0];
//        messageListener.onMessage("Java AOP after hook triggered.", CallerType.AFTER_HOOK);
//    }
    @Around("execution(* demonstrateJavaAOP(..))")
    public void injectSpanTest(ProceedingJoinPoint joinPoint) throws Throwable {
        MessageListener messageListener = (MessageListener) joinPoint.getArgs()[0];
        messageListener.onMessage("Java AOP before hook triggered.", CallerType.BEFORE_HOOK);

        joinPoint.proceed();

        messageListener.onMessage("Java AOP after hook triggered.", CallerType.AFTER_HOOK);
    }
}
