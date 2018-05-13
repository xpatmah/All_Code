package com.org.java.design.observerSecond;

public class ListnerEvent implements IEvent {

	int id;
	String name;
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getID() {
		return id;
	}

	public ListnerEvent(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public void setName(String name) {
		this.name=name;
	}

	@Override
	public void setId(int id) {
		this.id=id;
	}

}
