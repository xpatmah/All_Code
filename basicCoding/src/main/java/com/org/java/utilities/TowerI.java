package com.org.java.utilities;

public class TowerI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        TowerI tower = new TowerI();
        tower.toi(3, 'A', 'B', 'C');
        
	}

	public void toi(int n , char BEG , char END, char AUX){
		if(n>=1){
			 System.out.println(BEG +" "+ AUX +" "+ END );
			 toi(n-1 , BEG , AUX , END );
			 System.out.println("Move disk " + n+" from "+ BEG + " to " + END );
		     toi(n-1 , AUX , END , BEG );
		}
	}
	
}
