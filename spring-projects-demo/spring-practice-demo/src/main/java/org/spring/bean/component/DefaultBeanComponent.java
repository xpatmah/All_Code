package org.spring.bean.component;

import org.springframework.stereotype.Component;

import org.spring.interfaces.IShape;

@Component
public class DefaultBeanComponent implements IShape {

	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("This is the default bean ");
	}

}
