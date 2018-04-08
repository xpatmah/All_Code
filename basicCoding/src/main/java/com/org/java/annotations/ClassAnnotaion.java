package com.org.java.annotations;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ClassAnnotaion {

	@MyAnnotation(putValue="NewLocal",putInt=45)
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Class myanno = MyAnnotation.class;
		
		Method[] method = myanno.getMethods();
		
		for(Method m : method){
			System.out.println(m.getName());
			System.out.println(Modifier.isPublic(m.getModifiers()));
			System.out.println(Modifier.isAbstract(m.getModifiers()));
			System.out.println(Modifier.isPrivate(m.getModifiers()));
		}
		
		
	}

}
