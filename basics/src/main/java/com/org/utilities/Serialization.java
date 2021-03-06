package com.org.utilities;

import java.io.*;

class Myclass implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1145228984632531044L;
	String s;
	int i;
	double d;
	Myclass (String s, int i, double d){
		this.d = d;
		this.i = i;
		this.s = s;
	}
}

public class Serialization {
	public static void main(String[] args) {
		try {
			Myclass object1 = new Myclass("Hello", -7, 2.1e10);
			FileOutputStream fos = new FileOutputStream("serial");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(object1);
			oos.flush();
			oos.close();
		}
		catch(Exception e) {
			System.out.println("Serialization" + e);
			System.exit(0);
		}
		try {
			Myclass object2;
			FileInputStream fis = new FileInputStream("serial");
			ObjectInputStream ois = new ObjectInputStream(fis);
			object2 = (Myclass)ois.readObject();
			ois.close();
			System.out.println(object2);		    	
		}
		catch (Exception e) {
			System.out.print("deserialization" + e);
			System.exit(0);
		}
	}
}

