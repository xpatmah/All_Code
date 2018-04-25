package com.tricky;
class A
{
	
	void method(Integer i)
	{
		//method(int)
	}
	
	final void getmethod() {
		
	}
}

class B extends A
{
	
	void method(int i)
	{
		//method(Integer)
	}
	
 //   private void getmethod() {
		
	//}
}