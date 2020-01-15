	package com.org.designpatterns.first.factory;
	
	public class USACarFactory implements IFactory {
	
		@Override
		public Car buildCar(Model model) {
		Car car = new Car();
		car.setChassisNo("vvvsdfvsdfv");
		car.setCost("123455 Rs");
		car.setMode("AXL-I");
		car.setType(model.name());
		return car;
		}
	}
