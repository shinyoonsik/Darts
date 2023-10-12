package com.example.darts.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.example.darts.service..*Service.*(..))")
    public void serviceExecution() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void myPostMapping() {
    }

    // 위의 myPostMapping()메소드 실행전에 수행할 로직을 명시
    @Before("myPostMapping()")
    public void beforeMyPostMapping() {
    }

    @After("serviceExecution()")
    public void afterServiceExecution() {
    }

    @AfterReturning(pointcut = "serviceExecution()", returning = "result")
    public void afterReturningService(JoinPoint joinPoint, Object result) {
    }

    @Around("serviceExecution()")
    public Object aroundServiceExecution(ProceedingJoinPoint pjp) throws Throwable {
        return pjp.proceed();
    }

    @AfterThrowing(pointcut = "serviceExecution()", throwing = "ex")
    public void afterThrowingServiceExecution(JoinPoint joinPoint, Throwable ex) throws Throwable {

    }


}
