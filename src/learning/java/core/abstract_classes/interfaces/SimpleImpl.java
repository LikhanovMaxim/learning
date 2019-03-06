package learning.java.core.abstract_classes.interfaces;

/**
 * @author Maksim_Likhanov
 */
public class SimpleImpl implements ChildInterface{
	@Override
	public void print() {
		System.out.println(MIN + " "+ MAX);
	}

	@Override
	public int sumUp() {
		return MIN + MAX;
	}
}
