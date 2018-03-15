package learning.patterns.behavioral.visitor.visitor;

import learning.patterns.behavioral.visitor.shapes.Circle;
import learning.patterns.behavioral.visitor.shapes.CompoundShape;
import learning.patterns.behavioral.visitor.shapes.Dot;
import learning.patterns.behavioral.visitor.shapes.Rectangle;
import learning.patterns.behavioral.visitor.shapes.Shape;

/**
 * @author Maksim_Likhanov
 */
public class SecondVisitor implements Visitor {

	public String doSmth(Shape... shapes) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Shape shape : shapes) {
			stringBuilder.append(shape.accept(this));
			stringBuilder.append("\n");

		}
		return stringBuilder.toString();

	}

	@Override
	public String visitDot(Dot dot) {
		return "visit Dot";
	}

	@Override
	public String visitCircle(Circle circle) {
		return "visit Circle";
	}

	@Override
	public String visitRectangle(Rectangle rectangle) {
		return "visit Rectangle";
	}

	@Override
	public String visitCompoundGraphic(CompoundShape cg) {
		return "visit Compound";
	}
}
