package org.spring.bean.component;

import javax.annotation.PostConstruct;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectAdvice {


    @After("execution(* get*(..))")
    public void executeAfterAdvice() {
        System.out.println("This is my first Aspect Application");
    }

}
