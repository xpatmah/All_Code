package com.org.problemsolving.ds.first.programming.practice.ds.prog;



import java.util.Arrays;

public class BigIntegerSolution {

	public static void main(String[] args) {
	/*	Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for(int arr_i=0; arr_i < n; arr_i++){
			arr[arr_i] = in.nextInt();
		}*/
		int[] arr = {1000000001, 1000000002, 1000000003, 1000000004, 1000000005,1000000006,1000000007,1000000008,1000000009};
		
		String value = bigIntSum(arr);
		System.out.println(value);


	}

	private static String  bigIntSum(int[] arr){
		char[][] charConvertedArray = new char[arr.length][];
		char[] sum  = new char[new Integer(arr[0]).toString().length()+2];  
		Arrays.fill(sum, '0');
		for(int i=0;i<arr.length;i++){
			charConvertedArray[i]=new String(new Integer(arr[i]).toString()).toCharArray();
		}
		int length = charConvertedArray.length;
		int carry=0;
		for(int i=length-1;i>=0;i--){
			for(int j=charConvertedArray[i].length-1;j>=0;j--){
				int value =Integer.parseInt(""+sum[j+2])+Integer.parseInt(""+charConvertedArray[i][j])+carry;
				String stringResult=new String(new Integer(value).toString());
				char[] charArray = new String(new Integer(value).toString()).toCharArray();
				if(charArray.length==2){
					sum[j+2]=charArray[1];
					carry=Integer.parseInt(new String(charArray[0]+""));
				}else{
					carry=0;
					sum[j+2]=new String(new Integer(value).toString()).toCharArray()[0];
				}
			}
		}
		return new String(sum).replaceFirst("^0*", "");
	}
}

