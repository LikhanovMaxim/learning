package learning.certification.chapter4;

public class App {
	public static void main(String[] args) {
		double a = 0.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001;
		double zero = 0.0;
		if (isNotZero2(zero)) {
			System.out.println("not zero");
		} else {
			System.out.println("zero");
		}
	}

	private static boolean isNotZero2(double value) {
		return !isZero2(value);
	}

	private static boolean isZero2(double value) {
		return Math.abs(value) < 2 * Double.MIN_VALUE;
	}

	//	public static void varags(int... nums, String string){}

	private static boolean isZero(double value) {
		return Double.compare(value, 0.0) != 0;
	}

	private static boolean isNotZero(double value) {
		return !isZero(value);
	}
}
