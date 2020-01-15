package com.org.collections;

import java.util.ArrayList;
import java.util.List;

public class ComparatorUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Suzuki suz = new Suzuki(34, 56);
		Suzuki suz2 = new Suzuki(67, 76);
		Suzuki suz3 = new Suzuki(1, 56);
		Suzuki suz4 = new Suzuki(10, 76);
		Suzuki suz5 = new Suzuki(23, 56);
		Suzuki suz6 = new Suzuki(54, 76);
		Suzuki suz7 = new Suzuki(44, 56);
		Suzuki suz8 = new Suzuki(97, 76);
		
		
		List<Suzuki> suziList = new ArrayList<Suzuki>();
		suziList.add(suz);
		suziList.add(suz2);
		suziList.add(suz3);
		suziList.add(suz4);
		suziList.add(suz5);
		suziList.add(suz6);
		suziList.add(suz7);
		suziList.add(suz8);
		
		
		Suzuki max = Comparators.max(suziList, Comparators.reverseCom());
		System.out.println(max.racePoint);
	}

}
