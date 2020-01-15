package ds.programming.practice.dynamic;


public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
	     System.out.println(longestIncreasingSubSequence(arr));
	
	}
	
	public static int longestIncreasingSubSequence(int[] array){
		
		if(array.length ==0){
			return 0;
		}

		int[] table = new int[array.length];
		
		table[0] = 1;
		
		for(int i = 1 ; i < array.length ;i++){
			for(int j = 0 ; j < i ; j++){
				if(array[i] > array[j] && table[j]+1 > table[i]){
					table[i] = table[j]+1;
				}
			}
		}
		int max = 0;
		for(int i = 0 ;i < table.length ; i++){
			if(max < table[i]){
				max =  table[i];
			}
		}
		return  max;
		
	}

}
