package com.org.dynamic;

public class LongestRepeatitiveSubSequesce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "AABEBCDD";
		
		System.out.println(longestRepetativeSubSequence(str.toCharArray()));
		
	}
	
	private static String longestRepetativeSubSequence(char[] arr){
		
		int[][] array = new int[arr.length+1][arr.length+1];
		
		for(int i = 0 ;i <= arr.length ;i++){
			for(int j = 0 ; j <= arr.length ;j++){
				if(i==0 || j ==0){
					array[i][j] = 0;
				}else{
					if(arr[i-1] == arr[j-1] && i!=j){
						array[i][j] = array[i-1][j-1]+1;
					}else{
						array[i][j] = Math.max(array[i][j-1],array[i-1][j]);
					}
				}
			}
		}
		
		int i = arr.length;
		int j = i;
		String res="";
		while(i > 0 && j >0){
			
			if(array[i][j] == array[i-1][j-1] +1){
				res = res + arr[i-1]+"";
				i--;
				j--;
			}else if(array[i][j] == array[i-1][j]){
				i--;
			}else{
				j--;
			}
		}
		
		StringBuilder builder = new StringBuilder(res);
		
		return builder.reverse().toString();
		
	}

}
