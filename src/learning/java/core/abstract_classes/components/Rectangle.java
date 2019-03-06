package learning.java.core.abstract_classes.components;

/**
 * @author Maksim_Likhanov
 */
public class Rectangle extends Figure {

	private int second;

	private Rectangle(int a) {
		super(a);
	}

	public Rectangle(int a, int b){
		super(a);
		second = b;
	}

	@Override
	public void calculateArea() {
		area = firstParam * second;
	}
}
