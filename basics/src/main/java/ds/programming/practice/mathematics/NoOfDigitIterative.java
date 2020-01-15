package ds.programming.practice.mathematics;

public class NoOfDigitIterative {

	public static void main(String[] args) {
		int n = 10000;
		int count = 0;
		while(n>0) {
			n = n/10;
			count++;
		}
		System.out.println(count);
		n = 10000;
		NoOfDigitIterative iterative = new NoOfDigitIterative();
		System.out.println(iterative.getNoOFDigit(n));
	}
	
	public int getNoOFDigit(int n) {
		if(n == 0) {
			return 0;
		}
		return 1 + getNoOFDigit(n/10);
	}

	
}
