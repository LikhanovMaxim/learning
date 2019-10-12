package learning.patterns.behavioral.visitor.shapes;

import learning.patterns.behavioral.visitor.visitor.Visitor;

/**
 * @author Maksim_Likhanov
 */
public class Circle extends Dot {
	private int radius;

	public Circle(int id, int x, int y, int radius) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	@Override
	public String accept(Visitor visitor) {
		return visitor.visitCircle(this);
	}

	public int getRadius() {
		return radius;
	}
}
