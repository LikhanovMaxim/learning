package learning.certification.chapter6Exception;

public class App {

	public static void main(String[] args) {
		System.out.println("ifWeThrowExceptionWeCatchFinallyAndRun");
//		ifWeThrowExceptionWeCatchFinallyAndRun();
		System.out.println("\nsecond");
//		second();

		third();
		//		area();
	}

	private static void fall() throws Exception {
		throw new Exception();
	}

	private static void ifWeThrowExceptionWeCatchFinallyAndRun() {
		try {
			fall();
			System.out.println("after fall");
		} catch (Exception e) {
			System.out.println("we catch exception");
		} finally {
			System.out.println("block finally");
		}
		System.out.println("after try");
	}

	private static void second() {
		if (true) {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("I am alive!");
		}
		System.out.println("I am alive 2!");
	}

	private static void third() {
		fourth();
	}

	private static void fourth() {
		throw new NullPointerException();
	}

}
