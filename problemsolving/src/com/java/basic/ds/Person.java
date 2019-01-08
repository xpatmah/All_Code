package com.java.basic.ds;

public final class Person implements Comparable<Person>{

	private final String name;
	
	private final int id;
	
	public Person(String name , int id){
		this.name = name;
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", id=" + id + "]";
	}

	public String getName() {
		return name;
	}


	public int getId() {
		return id;
	}

	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return Integer.compare(o.getId(), this.getId());
	}
	
}
