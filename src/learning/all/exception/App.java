package learning.all.exception;

import learning.all.exception.unchecked.SmthException;

import static java.lang.Integer.parseInt;

public class App {
	/** @see learning.sertification.chapter6Exception.App
	 *
	 */
	public static void main(String[] args) {
		try {
			throwCheckedException();
		} catch (Exception e) {
			System.out.println("coug");
		}

		example();

//		throwUncheckedException();
	}
	private static void throwCheckedException() throws Exception {
		throw new Exception();
	}
	private static void example() {
		try {
			int a = parseInt("s");
		} catch (NumberFormatException e) {
			System.out.println("Vah");
		} finally {
			System.out.println("I do it!");
		}
	}

	private static void throwUncheckedException() {
		throw new SmthException();
	}
}
