package learning.patterns.creational.builder;

import learning.patterns.creational.builder.builders.CarBuilder;
import learning.patterns.creational.builder.builders.CarManualBuilder;
import learning.patterns.creational.builder.builders.ToyCarBuilder;
import learning.patterns.creational.builder.director.Director;
import learning.patterns.creational.builder.products.Car;
import learning.patterns.creational.builder.products.Manual;
import learning.patterns.creational.builder.products.ToyCar;
import learning.patterns.creational.builder.сomponents.Engine;

/**
 * Director constructs products using a Builder object. Usually, client assigns a builder instance to a director
 * just once via constructor parameters. Then director uses that single builder object for all further construction.
 * But there is an alternative when a builder is passed to the main production method of a director.
 *
 * Note, that Builder does not require creating a director class. The separate director class is
 * handy when you have several product variations that require different construction processes.
 * Director can encapsulate all that code inside a single class.
 *
 * Also
 * @see java.lang.StringBuilder#append
 * @see java.lang.StringBuffer#append
 * @see javax.swing.GroupLayout.Group#addComponent
 * @see java.lang.Appendable
 *
 * @author maksim_likhanov
 */
public class Client {
	public static void main(String[] args) {
		Director director = new Director();

		Car car = buildCar(director);
		System.out.println("Car built:\n" + car.getType());

		Manual carManual = buildCarManual(director);
		System.out.println("\nCar manual built:\n" + carManual.print());

		ToyCar toyCar = buildToyCar(director);
		System.out.println(toyCar.getType());
	}

	private static ToyCar buildToyCar(Director director) {
		ToyCarBuilder builder = new ToyCarBuilder();
		Engine engine = new Engine(0.01, 0);
		director.constructSportsCar(builder, engine);
		return builder.getResult();
	}

	private static Car buildCar(Director director) {
		// Директор получает объект конкретного строителя от клиента
		// (приложения). Приложение само знает какой строитель использовать,
		// чтобы получить нужный продукт.
		CarBuilder builder = new CarBuilder();
		director.constructSportsCar(builder);

		// Готовый продукт возвращает строитель, так как Директор чаще всего не
		// знает и не зависит от конкретных классов строителей и продуктов.
		return builder.getResult();

	}

	private static Manual buildCarManual(Director director) {
		CarManualBuilder manualBuilder = new CarManualBuilder();

		// Директор может знать больше одного рецепта строительства.
		director.constructSportsCar(manualBuilder);
		return manualBuilder.getResult();

	}
}
