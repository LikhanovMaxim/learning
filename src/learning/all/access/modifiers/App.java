package learning.all.access.modifiers;

import learning.all.access.modifiers.another.NotSamePackage;

/**
 * @author Maksim_Likhanov
 */
public class App {
	String a;

	void test() {
		//		 (package private) access
		SamePackage samePackage = new SamePackage();
		samePackage.field = 2;

		//		(package private) access is not worked here:
		NotSamePackage notSamePackage = new NotSamePackage();
		//		! Compile error:
		//		notSamePackage.field = 2;

		//Protected:
		Second second = new Second();
		second.protectedField = 2; // we can do it
		//		Don't compile:
		//		area.protectedAndPrivateInChildClass = 2; //
	}
}
