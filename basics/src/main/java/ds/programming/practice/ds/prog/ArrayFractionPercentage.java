package com.org.java.ds.prog;

import com.org.java.ds.DataStructureHelper;

public class ArrayFractionPercentage {

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = DataStructureHelper.getArrayWithPlusAndMinus();
		
		new Thread(new Runnable() {
 
			double positiveNo=0;
			double negativeN0=0;
			double noofZeros=0;
			double arrayLength=array.length;
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
               for(int a  : array){
            	   if(a==0){
            		   noofZeros++;
            	   }else if(a>0){
            		   positiveNo++;
            	   }else{
            		   negativeN0++;
            	   }
            }
               
               System.out.println(String.format("%.6f",(positiveNo/arrayLength)));
               System.out.println(String.format("%.6f",(negativeN0/arrayLength)));
               System.out.println(String.format("%.6f",(noofZeros/arrayLength)));
			}
		}).start();

	}

	
	
}
