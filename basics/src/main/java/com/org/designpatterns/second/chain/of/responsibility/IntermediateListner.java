package com.org.designpatterns.second.chain.of.responsibility;

public class IntermediateListner implements ICorrespondingListner<String>{

	ICorrespondingListner<String> listner;
	
	public IntermediateListner(ICorrespondingListner<String> listner) {
		this.listner=listner;
	}
	
	@Override
	public void listen(String obj) {
		if(null!=obj){
			if(obj.equals("intermediateClass")){
				System.out.println("I am the intermediateClass owner");
			}else{
				listner.listen(obj);
			}
		}

	}

}
