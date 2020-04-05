package com.org.problemsolving.mathematics;
class Quadratic 
{
	public static void main(String[] args) {
		Quadratic q = new Quadratic();
		q.quadraticRoots(1 ,4 ,8);
	}
	
    public void quadraticRoots(int a,int b,int c)
    {
         //Your code here
         int d = (b*b) - (4 * a *c);
   
         if(d >=0){
         int e  = (int) Math.floor((-b + Math.sqrt(d))/(2.0*a));
         int f = (int) Math.floor((-b - Math.sqrt(d))/(2.0*a));
         System.out.println(e+" "+f);
         }
         System.out.println("adad");
   }
}