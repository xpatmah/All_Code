package com.org.corejava.first.innner;

class MyInnerClassEx2 {

	private int x=10;
	
	Apple a1 = new Apple();
	
	public class Apple{
		public void seeOuter(){
			System.out.println(x);
			System.out.println(this);
			System.out.println(MyInnerClassEx2.this);
		}
	}
	
	public MyInnerClassEx2() {
		Apple a1 = new Apple();
	}

}
 

public class MyInnerClassEx{
	
	public static void main(String[] args) {
		MyInnerClassEx2 cl = new MyInnerClassEx2();
		MyInnerClassEx2.Apple a1 = new MyInnerClassEx2().new Apple();
	}
	@Overannotation(Local="sdfsf",value=665)
	public void getApple(){

		String s ="fjksdkf";
		class app{
			public void doStuff(){
				System.out.println(s);
			}

		}
	}
}