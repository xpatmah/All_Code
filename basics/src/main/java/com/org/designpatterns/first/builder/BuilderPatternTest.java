package com.org.designpatterns.first.builder;

public class BuilderPatternTest {

	public static void main(String[] args) {
		
		ObjectNeedToCreate.ObjectBuilder builder = new ObjectNeedToCreate.ObjectBuilder();
		
		ObjectNeedToCreate creater = builder.needPropert1("A").needPropert2("B").needPropert3("C").needPropert4("D").build();
		
		System.out.println(creater.toString());
		
		
	}
	
}
