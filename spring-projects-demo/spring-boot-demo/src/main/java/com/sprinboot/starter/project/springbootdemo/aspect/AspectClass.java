package com.sprinboot.starter.project.springbootdemo.aspect;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectClass {

    Map<String, Long> timeOF = new HashMap<>();

    Map<String, Long> time3 = new HashMap<>();

    @Pointcut("@annotation(com.sprinboot.starter.project.springbootdemo.aspect.Loggable)")
    private void loggable() {
    }


    @Before("loggable()")
    public void getExection(JoinPoint jp) {
        System.out.println(jp.hashCode());
    }

    @After("loggable()")
    public void getExectionAfter(JoinPoint jp) {
        System.out.println(jp.hashCode());
    }

    private String getName(JoinPoint jp) {
        MethodSignature sig = (MethodSignature) jp.getSignature();
        Method method = sig.getMethod();

        Loggable log = method.getAnnotation(Loggable.class);
        return log.value();
    }

}
