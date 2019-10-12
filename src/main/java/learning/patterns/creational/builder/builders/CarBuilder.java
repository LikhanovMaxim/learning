package learning.patterns.creational.builder.builders;

import learning.patterns.creational.builder.products.Car;
import learning.patterns.creational.builder.products.Type;
import learning.patterns.creational.builder.сomponents.Engine;
import learning.patterns.creational.builder.сomponents.GPSNavigator;
import learning.patterns.creational.builder.сomponents.Transmission;
import learning.patterns.creational.builder.сomponents.TripComputer;

/**
 * Конкретные строители реализуют шаги, объявленные в общем интерфейсе.
 * @author maksim_likhanov
 */
public class CarBuilder implements Builder {
	private Type type;
	private int seats;
	private Engine engine;
	private Transmission transmission;
	private TripComputer tripComputer;
	private GPSNavigator gpsNavigator;

	@Override
	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public void setSeats(int seats) {
		this.seats = seats;
	}

	@Override
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	@Override
	public void setTransmission(Transmission transmission) {
		this.transmission = transmission;
	}

	@Override
	public void setTripComputer(TripComputer tripComputer) {
		this.tripComputer = tripComputer;
	}

	@Override
	public void setGPSNavigator(GPSNavigator gpsNavigator) {
		this.gpsNavigator = gpsNavigator;
	}

	public Car getResult() {
		return new Car(type, seats, engine, transmission, tripComputer, gpsNavigator);
	}
}
