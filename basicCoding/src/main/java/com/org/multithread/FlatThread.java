package com.org.multithread;

import java.util.ArrayList;
import java.util.List;

public class FlatThread {

      private List<Integer> room1 = new ArrayList<Integer>();    
	   
       private List<Integer> room2 = new ArrayList<Integer>();       
       
      private List<Integer> room3 = new ArrayList<Integer>();  
       
      private  List<Integer> room4 = new ArrayList<Integer>();
      
      Object obj1 =  new Object();
      Object obj2 =  new Object();
      Object obj3 =  new Object();
      Object obj4 =  new Object();
	
      private  void enterInRoom1(){
    	  synchronized(obj1){
    		  try {
    			  Thread.sleep(1);
    		  } catch (InterruptedException e) {
    			  // TODO Auto-generated catch block
    			  e.printStackTrace();
    		  }
    		  room1.add(1); 
    	  }

      }
       
      private  void enterInRoom2(){
    	  synchronized(obj2){
    		  try {
    			  Thread.sleep(1);
    		  } catch (InterruptedException e) {
    			  // TODO Auto-generated catch block
    			  e.printStackTrace();
    		  }
    		  room2.add(1); 
    	  }
      }
       
      private void enterInRoom3(){
    	  synchronized(obj3){
    		  try {
    			  Thread.sleep(1);
    		  } catch (InterruptedException e) {
    			  // TODO Auto-generated catch block
    			  e.printStackTrace();
    		  }
    		  room3.add(1); 
    	  }
      }
       
      private void enterInRoom4(){ 
    	  synchronized(obj4){
    		  try {
    			  Thread.sleep(1);
    		  } catch (InterruptedException e) {
    			  // TODO Auto-generated catch block
    			  e.printStackTrace();
    		  }
    		  room4.add(1); 
    	  }}
       
       public void showFlat(){
    	   for(int i=0;i<1000;i++){
    		   enterInRoom1();
    		   enterInRoom2();
    		   enterInRoom3();
    		   enterInRoom4();
    	   }
       }
       
       public void printTotalVisite(){
    	     System.out.println(room1.size()+room2.size()+room3.size()+room4.size());   
       }
       
}
