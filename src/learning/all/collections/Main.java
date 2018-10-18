package learning.all.collections;

import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Set<String> availableShippingTypes = new HashSet<String>();
		availableShippingTypes.add("asd");
		availableShippingTypes.add("second");
		System.out.println(availableShippingTypes);
		change(availableShippingTypes);
		System.out.println(availableShippingTypes);

	}
	private static void change(Set<String> set){
		set= new HashSet<String>();
//		set.add((getShippingGroupManager()).getElectronicShippingType());
		set.add("change");
	}
}
