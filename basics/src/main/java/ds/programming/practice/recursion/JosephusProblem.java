package ds.programming.practice.recursion;

public class JosephusProblem {

	public static void main(String[] args) {
		
		System.out.println(getPosition(7, 3));
		
	}
	
	public static int getPosition(int n , int k) {
		if(n==1) {
			return n;
		}
		
		return (getPosition(n-1, k) + k-1)%n +1;
	}
	
}

