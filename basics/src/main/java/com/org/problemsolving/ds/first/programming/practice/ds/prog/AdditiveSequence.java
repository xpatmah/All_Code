package com.org.problemsolving.ds.first.programming.practice.ds.prog;

public class AdditiveSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    
		String sequence ="235312354";
        new AdditiveSequence().additiveSequence(sequence);
		
	}
     
    public void additiveSequence(String sequence){

          for(int i=0;i<=sequence.length()/2;i++){
        	  int firstNo = Integer.parseInt(sequence.substring(0, i+1));
        	   for(int j=i ; j<=(sequence.length() -i)/2 ; j++){
        		   int secondNo = Integer.parseInt(sequence.substring(i+1, j+1+1));
        		   boolean result = checkSum(sequence,firstNo , secondNo, j+1);
        		   if(result==true){
        			   System.out.println("The Sequence is aditive");
        			   break;
        		   }else{
        			   continue;
        		   }
        	   }
          }
    }
    
    private boolean checkSum(String sequence , int firstNo, int secondNo , int index) {
    	int totalSum = firstNo + secondNo;
        int lengthofNo = Integer.toString(totalSum).length();
        if(index == sequence.length()-1){
            return true;
        }
        else if(index+lengthofNo+1 > sequence.length()){
        	return false;
        }
        int nextTotal = Integer.parseInt(sequence.substring(index+1,index+lengthofNo+1));
        
        if(totalSum ==nextTotal){
        	return checkSum(sequence, secondNo, nextTotal, index+lengthofNo);
        }else{
        	return false;
        }
	}

}
