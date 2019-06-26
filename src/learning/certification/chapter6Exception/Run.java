package learning.certification.chapter6Exception;

import java.util.NoSuchElementException;

/**
 * @author Maksim_Likhanov
 */
public class Run {
	public static void main(String[] args) {
		try{
			doIt();
		} catch (NoSuchElementException e){
			e.getMessage();
		}

	}

	private static void doIt() {
		throw new RuntimeException("hja");
	}
}
