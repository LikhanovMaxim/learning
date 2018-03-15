package learning.patterns.behavioral.visitor.visitor;

import learning.patterns.behavioral.visitor.shapes.Circle;
import learning.patterns.behavioral.visitor.shapes.CompoundShape;
import learning.patterns.behavioral.visitor.shapes.Dot;
import learning.patterns.behavioral.visitor.shapes.Rectangle;

public interface Visitor {
	public String visitDot(Dot dot);

	public String visitCircle(Circle circle);

	public String visitRectangle(Rectangle rectangle);

	public String visitCompoundGraphic(CompoundShape cg);
}