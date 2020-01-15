package com.org.domain.first;

public class Cars implements Engine, Vechicle{

	int price;
	int version;

	protected Cars(int price, int version){
		this.price=price;
		this.version=version;
	}

	public int compareTo(Cars cars){
		if(this.price > cars.price){
			return 1;
		}else if(this.price< cars.price){
			return -1;
		}else{
			return 0;
		}
	}

	public String makeandmodel() {
		return Vechicle.super.make();
	}

	public Number getNumber(){
		return 0;
	}

}
