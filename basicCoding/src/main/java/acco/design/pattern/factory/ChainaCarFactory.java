package acco.design.pattern.factory;

public class ChainaCarFactory implements IFactory{

	@Override
	public Car buildCar(Model model) {
	Car car = new Car();
	car.setChassisNo("bsfvjdjjfffv32412");
	car.setCost("35545 Rs");
	car.setMode("XIL-I");
	car.setType(model.name());
	
	return car;}

}
