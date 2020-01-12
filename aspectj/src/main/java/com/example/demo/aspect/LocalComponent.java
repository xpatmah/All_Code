package com.example.demo.aspect;

import java.lang.reflect.Field;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class LocalComponent implements ApplicationListener<ApplicationEvent> { //implements BeanPostProcessor {
	/*
	 * @Override public Object postProcessBeforeInitialization(Object bean, String
	 * beanName) throws BeansException { //
	 * System.out.println(bean.getClass().getName());
	 * if(bean.getClass().isAnnotationPresent(SysProperties.class)){ Field[] fields
	 * = bean.getClass().getFields(); for(Field sys : fields) {
	 * System.out.println(sys.getName());
	 * if(Enumsdid.class.isAssignableFrom(sys.getType())) {
	 * 
	 * } } } return bean; }
	 * 
	 * @Override public Object postProcessAfterInitialization(Object bean, String
	 * beanName) throws BeansException { // TODO Auto-generated method stub //
	 * System.out.println(bean.getClass().getName());
	 * if(bean.getClass().isAnnotationPresent(SysProperties.class)){ Field[] fields
	 * = bean.getClass().getFields(); for(Field sys : fields) {
	 * System.out.println(sys.getName());
	 * if(Enumsdid.class.isAssignableFrom(sys.getType())) {
	 * 
	 * } } } return bean; }
	 */
	
	public void inititialize() {
		
	}
	
}
