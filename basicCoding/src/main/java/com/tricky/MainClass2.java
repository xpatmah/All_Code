package com.tricky;
class AG
{
	
	AG a = new AG();
	
	static void staticMethod()
	{
		System.out.println("Static Method");
	}
}

public class MainClass2
{
	public static void main(String[] args)
	{
		AG a = new AG();
        System.out.println(a.a);
		a.staticMethod();
	}
}