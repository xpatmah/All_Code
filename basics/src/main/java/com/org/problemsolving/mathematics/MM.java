package com.org.problemsolving.mathematics;

import java.util.Arrays;

class MM
{
    public static void main(String[] args) {
		MM m1 = new MM();
		//m1.mean(A, N);
	}
	
  public int median(int A[],int N)
    {
      
       Arrays.sort(A);
       
       if(N%2!=0){
           return A[N/2];
       }else{
          return (A[N/2] + A[(N/2)-1])/2 ;
       }
    }
    
    public int mean(int A[],int N)
    {
       //Your code here
       int sum = 0 ;
       for(int i = 0; i < N  ;i++){
           sum += A[i];
       }
       return sum/N;
    }
}
