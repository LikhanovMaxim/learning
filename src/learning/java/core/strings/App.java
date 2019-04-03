package learning.java.core.strings;

import com.google.common.base.Objects;

/**
 * @author Maksim_Likhanov
 */
public class App {

	public static void main(String[] args) {
		String str = null;
		System.out.println("String: " + str);

		Object o = null;
		String s = (String)o;
		System.out.println(s);
		System.out.println(isEmpty(s)); //true

		guava();
	}

	private static void guava() {
		String token = null;
		String token2 = "asd+";

		System.out.println();
		System.out.println(Objects.equal(token, token2)); //false. No NPE
	}

	//like atg.core.util;
	public static boolean isEmpty(String pStr) {
		return pStr == null || pStr.length() == 0;
	}
}
