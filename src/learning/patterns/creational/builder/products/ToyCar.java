package learning.patterns.creational.builder.products;

import learning.patterns.creational.builder.сomponents.Engine;
import learning.patterns.creational.builder.сomponents.Transmission;
import learning.patterns.creational.builder.сomponents.TripComputer;

/**
 * @author maksim_likhanov
 */
public class ToyCar {
	private final Type type;
	private final int seats;
	private final Engine engine;
	private final Transmission transmission;
	private final TripComputer tripComputer;

	public ToyCar(Type type, int seats, Engine engine, Transmission transmission, TripComputer tripComputer) {
		this.type = type;
		this.seats = seats;
		this.engine = engine;
		this.transmission = transmission;
		this.tripComputer = tripComputer;
	}

	public Type getType() {
		return type;
	}

	public int getSeats() {
		return seats;
	}

	public Engine getEngine() {
		return engine;
	}

	public Transmission getTransmission() {
		return transmission;
	}

	public TripComputer getTripComputer() {
		return tripComputer;
	}

}
