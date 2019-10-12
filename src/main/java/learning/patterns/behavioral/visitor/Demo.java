package learning.patterns.behavioral.visitor;

import learning.patterns.behavioral.visitor.shapes.Circle;
import learning.patterns.behavioral.visitor.shapes.CompoundShape;
import learning.patterns.behavioral.visitor.shapes.Dot;
import learning.patterns.behavioral.visitor.shapes.Rectangle;
import learning.patterns.behavioral.visitor.shapes.Shape;
import learning.patterns.behavioral.visitor.visitor.SecondVisitor;
import learning.patterns.behavioral.visitor.visitor.XMLExportVisitor;

/**
 * Ваша команда разрабатывает приложение, работающее с геоданными в виде графа. Узлами графа могут быть как города,
 * так и другие локации, будь то достопримечательности, большие предприятия и так далее. Каждый узел имеет ссылки на другие,
 * ближайшие к нему узлы. Для каждого типа узла имеется свой класс, а каждый узел представлен отдельным объектом.
 *
 * Ваша задача — сделать экспорт этого графа в XML.
 *
 * 1. Системный архитектор сослался на то, что код классов узлов сейчас очень стабилен и от него многое зависит, поэтому он не
 * хочет рисковать и позволять кому-либо его трогать.
 *
 * 2. К тому же он сомневался в том, что экспорт в XML вообще уместен в рамках этих классов. Их основная задача была связана
 * с геоданными, а экспорт выглядит в рамках этих классов чужеродно.
 *
 * 3. Была и ещё одна причина запрета. Если на следующей неделе вам бы понадобился экспорт в какой-то другой формат данных,
 * то эти классы снова пришлось бы менять.
 *
 *
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