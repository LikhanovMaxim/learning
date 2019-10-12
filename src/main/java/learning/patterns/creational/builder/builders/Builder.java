package learning.patterns.creational.builder.builders;

import learning.patterns.creational.builder.products.Type;
import learning.patterns.creational.builder.сomponents.Engine;
import learning.patterns.creational.builder.сomponents.GPSNavigator;
import learning.patterns.creational.builder.сomponents.Transmission;
import learning.patterns.creational.builder.сomponents.TripComputer;

/**
 * Builder declares steps required to build a product.
 * @author maksim_likhanov
 */
public interface Builder {
	public void setType(Type type);

	public void setSeats(int seats);

	public void setEngine(Engine engine);

	public void setTransmission(Transmission transmission);

	public void setTripComputer(TripComputer tripComputer);

	public void setGPSNavigator(GPSNavigator gpsNavigator);
}
