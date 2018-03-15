package learning.patterns.behavioral.visitor;

import learning.patterns.behavioral.visitor.shapes.Circle;
import learning.patterns.behavioral.visitor.shapes.CompoundShape;
import learning.patterns.behavioral.visitor.shapes.Dot;
import learning.patterns.behavioral.visitor.shapes.Rectangle;
import learning.patterns.behavioral.visitor.shapes.Shape;
import learning.patterns.behavioral.visitor.visitor.SecondVisitor;
import learning.patterns.behavioral.visitor.visitor.XMLExportVisitor;

/**
 * @author Maksim_Likhanov
 */
public class Demo {

	public static void main(String[] args) {
		Dot dot = new Dot(1, 10, 55);
		Circle circle = new Circle(2, 23, 15, 10);
		Rectangle rectangle = new Rectangle(3, 10, 17, 20, 30);

		CompoundShape compoundShape = new CompoundShape(4);
		compoundShape.add(dot);
		compoundShape.add(circle);
		compoundShape.add(rectangle);

		CompoundShape c = new CompoundShape(5);
		c.add(dot);
		compoundShape.add(c);

		myVisitor(circle, compoundShape);
		export(circle, compoundShape);
	}

	private static void export(Shape... shapes) {
		XMLExportVisitor exportVisitor = new XMLExportVisitor();
		System.out.println(exportVisitor.export(shapes));
	}

	private static void myVisitor(Circle circle, CompoundShape compoundShape) {
		SecondVisitor visitor = new SecondVisitor();
		System.out.println(visitor.doSmth(circle, compoundShape));
	}
}