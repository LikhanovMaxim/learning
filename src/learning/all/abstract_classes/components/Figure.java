package learning.all.abstract_classes.components;

/**
 * @author Maksim_Likhanov
 */
abstract public class Figure {

	protected int firstParam;
	protected String name;
	public int area;

	Figure(int a) {
		firstParam = a;
	}

	abstract public void calculateArea();

	@Override
	public String toString() {
		return "Figure{" + "firstParam=" + firstParam + ", name=" + name + ", area=" + area + '}';
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
