package com.org.problemsolving.dp.first;

public class AllSequence {

	public static void main(String[] args) {
		String input = "abc";
		AllSequence sequence = new AllSequence();
		for(int i = 0 ; i < input.length() ; i++) {
			sequence.printString(input, i, 2);
		}
		
	}
	
    private void printString(String input , int startingpoint , int endPoint) {
    	  if(startingpoint > endPoint) {
    		  return;
    	  }	else {
    		  System.out.println(input.substring(startingpoint, endPoint+1));
    		  printString(input, startingpoint, endPoint-1);
    	  }
    	
    }
}
