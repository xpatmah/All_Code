package com.org.java.design.observerSecond;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public  class DataBaseObserver implements Observer<IListner<IEvent>> ,Runnable {

	List<IListner<IEvent>> listnerList = new ArrayList<IListner<IEvent>>();

	public static LinkedBlockingQueue<IEvent> queue = new LinkedBlockingQueue<IEvent>();
	
	@Override
	public void addListner(IListner<IEvent> listner) {
		listnerList.add(listner);
	}

	@Override
	public void removeListner(IListner<IEvent> listner) {
		listnerList.remove(listner);
	}

	@Override
	public void notiffy() {
		IEvent event;
		try {
			event = queue.take();
			for(IListner<IEvent>  listner : listnerList){
				listner.update(event);
			} 
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
	}

	@Override
	public void run() {
		while(true){
			notiffy();
		}
	}
}
