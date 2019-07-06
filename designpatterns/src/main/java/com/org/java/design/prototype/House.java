package com.org.java.design.prototype;

public class House implements Cloneable{

	private String name;
	
	private String id;
	
	private Record record;
	
	public House(String id , String name , Record record ) {
		this.id = id;
		this.name = name;
		this.record = record;
	}
	
	public House clone() {
		try {
			Record record2 = record.clone();
			House h = (House)super.clone();
			h.record = record2;
			return h;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String toString() {
		return "House [name=" + name + ", id=" + id + ", record=" + record + "]";
	}
	
}
