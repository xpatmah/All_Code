package com.org.java.utilities;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class A{
	static String a = "";
	
	void ocerload(){
		
	}
}

class B extends A{
	static String a="sdfsdfsdf";
	void ocerload(){
		
	}
}

public class Main<T> {

	private int count=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println(A.a);
		Class<?> subclass = SubType.class;
	                   
		
		
		Method[] metho = subclass.getDeclaredMethods();
		for(Method me  : metho){
			System.out.println(me.toString());
		   Member mem = (Member)subclass.getFields()[0];
		   System.out.println(mem.getName());
		   List<?> listu=Arrays.asList();
		  Class<Integer> intclass =Integer.class; 
		  
		
		}
		
	   List<Integer> arrayList = new ArrayList<Integer>();
	   
	   
	   
	   
	   Class<? extends List> k = arrayList.getClass();
	   
	
	   Main maine = new Main();
		maine.goAndWait();
      
       
	}
	
	
	public  void goAndWait(){/*
			
		 Thread t1 = new Thread(() -> {
	    	   System.out.println("Hello");
	    	   for(int i=0;i<100000;i++){
	    		   count++;
	    	   }
	       });
	       
	       Thread t2 = new Thread(() -> {
	    	   System.out.println("Hello");
	    	   for(int i=0;i<100000;i++){
	    		   count++;
	    	   }
	       });
	       
	       t1.start();
	       t2.start();
	       try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
	       System.out.println("Waiting for me "+count);
	       
	*/}
	
		  
}
