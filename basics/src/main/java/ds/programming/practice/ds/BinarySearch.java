package com.org.java.ds;

public  class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = DataStructureHelper.getSortedArray();
		
		System.out.println("element found at location "+(binarySearch(arr,0,arr.length-1,97)+1));
	}
	
	public static int binarySearch(int[] arr , int begin , int end, int element){
		if(begin > end || end < begin){
			return -1;
		}
		int mid = begin+ (end-begin)/2;
		if(arr[mid]>element){
			return binarySearch(arr, begin, mid-1,element);
		}else if(arr[mid]<element){
			return binarySearch(arr, mid+1, end,element);
		}else{
			return mid;
		}
		
	}

}
