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
 * TODO translate to english
 * Проблема: Представьте сложный объект, требующий кропотливой пошаговой инициализации множества
 * полей и вложенных объектов. Код инициализации таких объектов обычно спрятан внутри монструозного
 * конструктора с десятком параметров. Либо ещё хуже — распылён по всему клиентскому коду.
 *
 * Например, давайте подумаем о том, как создать объект Дом. Чтобы построить стандартный дом, нужно
 * поставить 4 стены, установить двери, вставить пару окон и постелить крышу. Но что, если вы хотите
 * дом побольше да посветлее, имеющий сад, бассейн, и прочее добро?
 *
 * Самое простое решение — расширить класс Дом, создав подклассы для всех комбинаций параметров дома.
 * Проблема такого подхода — это громадное количество классов, которые вам придётся создать.
 * Каждый новый параметр, вроде цвета обоев или материала кровли, заставит вас создавать всё больше и больше
 * классов для перечисления всех возможных вариантов.
 *
 * For more example:
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
