package com.org.corejava.second;
class AB
{
	static int i = 1111;

	static
	{
		i = i-- - --i;
	}

	{
		i = i++ + ++i;
	}
}

class BC extends AB
{
	static
	{
		i = --i - i--;
	}

	{
		i = ++i + i++;
	}
}

public class MainClass3
{
	public static void main(String[] args)
	{
		BC b = new BC();

		System.out.println(b.i);
	}
}