package ds.programming.practice.dynamic;

public class MaxdiffrenceIndex {

	static int endIndex = -1;
	static int lastIndex = -1;
	static int maxDiff = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = {100,80,29,1,5,9,7,28};
		maxDiff = getMaxDiff(array ,0, array.length-1);
		System.out.println(maxDiff);
		
	}
	
	public static int getMaxDiff(int[] array, int i , int j){
       if(i > j){
    	   return maxDiff;
       }
		if (array[i] <= array[j]){
			if (maxDiff < j-i){
				maxDiff = j-i;
				System.out.println(i+" "+j);
				return maxDiff;
			}else{
			    getMaxDiff( array ,i+1 , j);
				getMaxDiff(array ,i , j-1);
				return maxDiff;
			}
		}else{
			getMaxDiff( array ,i+1 , j);
			getMaxDiff(array ,i , j-1);
			return maxDiff;
		}
	}

}
