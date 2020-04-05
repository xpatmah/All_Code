package com.org.problemsolving.mathematics;
class GP 
{
    
	public static void main(String[] args) {
		GP gp = new GP();
		System.out.println(gp.termOfGP(84, 87, 3));
	}
	
	public double termOfGP(double A, double B, int N) {
		if (N == 1) {
			return A;
		}
		if (N == 2) {
			return B;
		}

		double r = B / A;
	  
		return  A * Math.pow(r, N-1);
	}
}