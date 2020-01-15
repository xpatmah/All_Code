package com.org.designpatterns.second.chain.of.responsibility;

public class MainListner implements ICorrespondingListner<String> {

	ICorrespondingListner<String> listner ;
	
	public MainListner(ICorrespondingListner<String> lisner) {
		this.listner=lisner;
	}

	@Override
	public void listen(String obj) {
		// TODO Auto-generated method stub
		if(null!=obj){
			if(obj.equals("mainClass")){
				System.out.println("I am the complete owner");
			}else{
				listner.listen(obj);
			}
		}
	}

}
