package learning.all.abstract_classes;

import learning.all.abstract_classes.components.Figure;
import learning.all.abstract_classes.components.Rectangle;
import learning.all.abstract_classes.components.Square;
import learning.all.abstract_classes.interfaces.ChildInterface;
import learning.all.abstract_classes.interfaces.SimpleImpl;

/**
 * @author Maksim_Likhanov
 */
public class App {

	public static void main(String[] args) {
		abstractCanNotHaveInstance();

		System.out.println("Abstractions:");
		usingAbstractions();

		System.out.println("Interfaces:");
		usingInterfaces();
	}

	private static void usingInterfaces() {
		ChildInterface impl = new SimpleImpl();
		impl.print();
		System.out.println(impl.sumUp());
	}

	private static void usingAbstractions() {
		Figure square = new Square(2);
		calculate(square);

		Figure rectangle = new Rectangle(2, 3);
		calculate(rectangle);
	}

	private static void abstractCanNotHaveInstance() {
		//		Abstract class is not an instance!
		//		Figure first = new Figure() ;
	}

	private static void calculate(Figure figure) {
		figure.calculateArea();
		System.out.println(figure.area);
	}
}
