package com.org.designpatterns.second.observerSecond;

public class DataBaseListner implements IListner<IEvent> {

	
	@Override
	public void update(IEvent event) {
		// TODO Auto-generated method stub
		System.out.println(event.getID() +"   "+ event.getName());
	}

}
