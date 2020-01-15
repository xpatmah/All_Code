package org.spring.bean.component;

import org.springframework.stereotype.Component;

import org.spring.interfaces.IShape;

@Component("rectangle")
public class Rectangle implements IShape {

	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("The Spring Context has been drawn");
	}

}
