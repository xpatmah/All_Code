package acco.design.pattern.factory;

public class IndiaCarFactory implements IFactory{

	@Override
	public Car buildCar(Model model) {
	Car car = new Car();
	car.setChassisNo("bsdfv32412");
	car.setCost("32435 Rs");
	car.setMode("XL-PI");
	car.setType(model.name());
	
	return car;
	}

}
