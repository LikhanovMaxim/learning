package learning.patterns.creational.builder.builders.requied.fields;

import learning.patterns.creational.builder.builders.Builder;
import learning.patterns.creational.builder.products.Type;
import learning.patterns.creational.builder.сomponents.Engine;
import learning.patterns.creational.builder.сomponents.GPSNavigator;
import learning.patterns.creational.builder.сomponents.Transmission;
import learning.patterns.creational.builder.сomponents.TripComputer;

/**
 * @author Maksim_Likhanov
 */

//TODO!!!!!!!!!!!!!!!!! Add a require field ///
public class SportCarBuilder implements Builder {
	private int countTurbine;
	private Type type;
	private int seats;
	private Engine engine;
	private Transmission transmission;
	private TripComputer tripComputer;
	private GPSNavigator gpsNavigator;

	private SportCarBuilder(ReqBuilder builder){
		countTurbine = builder.countTurbine;
	}

	public static CountTurbine builder(){
		return new ReqBuilder();
	}

	public static class ReqBuilder implements CountTurbine, ReqBuild{
		private int countTurbine;

		@Override
		public ReqBuild countTurbine(int count) {
			this.countTurbine = count;
			return this;
		}

		@Override
		public SportCarBuilder build() {
			return new SportCarBuilder(this);
		}
	}

	interface CountTurbine{
		public ReqBuild countTurbine(int count);
	}

	interface ReqBuild{
		SportCarBuilder build();
	}
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
}
