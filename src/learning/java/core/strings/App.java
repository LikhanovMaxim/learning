package learning.java.core.strings;

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
	}

	//like atg.core.util;
	public static boolean isEmpty(String pStr) {
		return pStr == null || pStr.length() == 0;
	}
}
