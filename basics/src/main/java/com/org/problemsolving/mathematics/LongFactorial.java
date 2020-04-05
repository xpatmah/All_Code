package com.org.problemsolving.mathematics;

public class LongFactorial {
   
	public static void main(String[] args) {
		LongFactorial fact = new LongFactorial();
		System.out.println(fact.digitsInFactorial(5));
	}
	
	    public int digitsInFactorial(int N)
	    {
	    	System.out.println(fact(N));
	    	
	         return noOfDigit(fact(N));
	    }

	    private long fact(long N){
	        if(N==0 || N==1){
	            return 1;
	        }
	        return N * fact(N-1);
	    }

	    private int noOfDigit(long N){
	        if(N<0){
	            return 0;
	        }
	        
	        if(N<=1){
	            return 1;
	        }
	         
	        return (int) Math.log10(N)+ 1;
	    }
}	
