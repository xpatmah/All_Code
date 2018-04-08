package acco.design.pattern.factory;

public class UKCarFactory implements IFactory {

	@Override
	public Car buildCar(Model model) {
		// TODO Auto-generated method stub
		
		Car car = new Car();
		car.setChassisNo("bsfvjdfv32412");
		car.setCost("32435545 Rs");
		car.setMode("XL-I");
		car.setType(model.name());
		
		return car;
	}

}
