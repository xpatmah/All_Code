package ds.programming.practice.arrays;

public class OneDuplicateOnly {

	public static void main(String[] args) {
		int[] array = { 5 ,5 ,8 ,8 ,11 ,11, 12, 12 ,14, 14, 24 ,27, 27, 28, 28 ,31 ,31 ,45, 45};

		int exorsum = array[0];

		for (int i = 1; i < array.length; i++) {
			exorsum ^= array[i];
		}
		
		System.out.println(exorsum);
	}
	
}
