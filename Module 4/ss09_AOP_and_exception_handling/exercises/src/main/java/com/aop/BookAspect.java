package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookAspect {
    public static int count=0;
    @AfterReturning(pointcut = "execution(* com.controller.BookController.borrowBook(..))")
    public void logAfterBorrow(JoinPoint joinPoint){
        System.err.println(joinPoint.getSignature().getName());
    }
    @AfterReturning(pointcut = "execution(* com.controller.BookController.returnBook(..))")
    public void logAfterReturn(JoinPoint joinPoint){
        System.err.println(joinPoint.getSignature().getName());
    }
    @After("execution(* com.controller.HomeController.*(..))")
    public void logAfterReturning(JoinPoint joinPoint){
        System.err.println("Số lượng người vào trang "+ ++count);
    }
}
