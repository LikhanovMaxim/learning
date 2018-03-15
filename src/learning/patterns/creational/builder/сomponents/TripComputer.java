package learning.patterns.creational.builder.сomponents;

import learning.patterns.creational.builder.products.Car;

/**
 * @author maksim_likhanov
 */
public class TripComputer {
	public void condition() {
		if (Engine.isStarted()) {
			System.out.println("CarBuilder is started");
		} else {
			System.out.println("CarBuilder isn't started");
		}
	}

	public void fuelLevel() {
		System.out.println("Level of fuel - " + Car.getFuel());
	}
}
