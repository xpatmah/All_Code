package com.org.java.ds.gen;

public abstract class MoterCycle implements Comparable<MoterCycle> {

	int racePoint;
	
	int brackSpeed;
	
	public MoterCycle(int racePoint,int brackSpeed) {
               this.racePoint=racePoint;
               this.brackSpeed=brackSpeed;
	}
	
	@Override
	public int compareTo(MoterCycle o) {
		// TODO Auto-generated method stub
		if(this.racePoint>o.racePoint){
			return 1;
		}else if(this.racePoint<o.racePoint){
			return -1;
		}else{
			return 0;
		}
	}

}
