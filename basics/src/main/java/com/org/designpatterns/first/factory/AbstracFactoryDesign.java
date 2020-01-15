package com.org.designpatterns.first.factory;

public class AbstracFactoryDesign {

	
	public static void main(String[] args) {
		IFactory factory = new CarFactory();
		Car Microcar = factory.buildCar(Model.MICRO);
		
		Car SedanCar = factory.buildCar(Model.SEDAN);
		
		System.out.println(Microcar.getChassisNo() + " "+ Microcar.getCost()+" "+ Microcar.getCountry()+" "
		+ Microcar.getMode()+" "+ Microcar.getType());
		
		System.out.println(SedanCar.getChassisNo() + " "+ SedanCar.getCost()+" "+ SedanCar.getCountry()+" "
				+ SedanCar.getMode()+" "+ SedanCar.getType());
		
	}
	
}
