package com.org.designpatterns.first.factory;

import java.util.Random;

public class CarFactory implements IFactory{

	@Override
	public Car buildCar(Model model) {
		// Search the location 
		// Supose the location is hard coded for n
		Random random = new Random();
		Location location = Location.values()[random.nextInt(3)];
		
		if(location.name().equals(location.UK.name())) {
			Car car = new UKCarFactory().buildCar(model);	
			car.setCountry(location.name());
		    return car;
		}else if(location.name().equals(location.CHINA.name())) {
			Car car = new ChainaCarFactory().buildCar(model);	
			car.setCountry(location.name());
			return car;
		}else if(location.name().equals(location.INDIA.name())) {
			Car car = new IndiaCarFactory().buildCar(model);
			car.setCountry(location.name());
			return car;
		}else {
			Car car = new USACarFactory().buildCar(model);
			car.setCountry(location.name());
			return car;
		}
	}

}
