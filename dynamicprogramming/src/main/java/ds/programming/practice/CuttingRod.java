package ds.programming.practice;

public class CuttingRod {
  
	public static void main(String[] args) {
	
		CuttingRod road = new CuttingRod();
		
		int price[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
	    
		int maxValueObtained  = road.cutMax(price, price.length);

	    System.out.println(maxValueObtained);
		
	}
	
	public int cutMax(int[] price , int n) {
		if(n<=0) {
			return 0 ;
		}
		
		int maxValue = Integer.MIN_VALUE;
		
		for(int i = 0  ; i < n ; i ++) {
			maxValue = Math.max(maxValue, price[i]+ cutMax(price, n-i-1));
		}
		
		return maxValue;
	}
}
