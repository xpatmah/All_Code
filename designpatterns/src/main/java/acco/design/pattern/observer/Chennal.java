package acco.design.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Chennal implements ISubject<IObserver> {

	private List<IObserver> observerlist = new ArrayList<>();
	
	public void addVideo() {
		System.out.println("new Video has been added successfully");
		notifyObserver();
	}
	
	@Override
	public void addObsever(IObserver observer) {
		// TODO Auto-generated method stub
		observerlist.add(observer);
	}

	@Override
	public void removeObserver(IObserver observer) {
		// TODO Auto-generated method stub
		observerlist.remove(observer);
	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		for(IObserver obj : observerlist) {
			obj.update();
		}
	}

}
