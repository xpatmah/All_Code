package com.org.spring.bean.component;

import org.springframework.stereotype.Component;

import com.org.spring.interfaces.IShape;

@Component("rectangle")
public class Rectangle implements IShape {

	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("The Spring Context has been drawn");
	}

}
