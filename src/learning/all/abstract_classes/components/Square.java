package learning.all.abstract_classes.components;

/**
 * @author Maksim_Likhanov
 */
public class Square extends Figure {

	public Square(int a) {
		super(a);
	}

	@Override
	public void calculateArea() {
		area = firstParam*firstParam;
	}

}
