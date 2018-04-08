package com.org.java.utilities;


public class LambdaExpressionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		   LambdaI lambda = (int a ,int b) -> {
			   return a+b;
		   };
	
		   System.out.println(lambda.add(23, 45));
		   
		   String Local  = "lkfdsjlkfjsd";
		   
		   Runnable ran =  () -> {
			   System.out.println("fdshkjdshfkds");
		   };
		   
		   
		   Thread thread = new Thread(ran);
		   thread.start();
		   

		   LambdaExpressionTest tess = new LambdaExpressionTest();
		   
		   tess.printValue();
	
		   
	        
		   
	}
	

	public void printValue(){
		
		
		Comparable<String> comparable = (String s1) -> {
	    	 if( this.equals(s1)){
	    		 return 1;
	    	 }
	    	 return -1;
	      };	
		
		System.out.println(comparable.compareTo("Local"));
	}
	
}
