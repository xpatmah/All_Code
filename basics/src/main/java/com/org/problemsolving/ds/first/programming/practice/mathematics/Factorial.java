package com.org.problemsolving.ds.first.programming.practice.mathematics;
class Factorial
{
    
	public static void main(String[] args) {
		Factorial fact = new Factorial();
		System.out.println(fact.factorial(5));
		System.out.println(fact.iterativeFace(5));
	}
	
    public long factorial (int N)
    {
        if(N==0 || N==1){
            return 1;
        }else{
            return N * factorial(N-1);
        }
    }
    
    public long iterativeFace(int N) {
    	
    	long fact = 1;
    	for(int i = 1 ; i <= N ; i ++) {
    		fact = fact * i;
    	}
    	
    	return fact;
    	
    }
    

}