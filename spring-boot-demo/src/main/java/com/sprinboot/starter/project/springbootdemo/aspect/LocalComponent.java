package com.example.demo.aspect;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class LocalComponent implements ApplicationListener<ApplicationEvent> { //implements BeanPostProcessor {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println(event.toString());
    }
}
