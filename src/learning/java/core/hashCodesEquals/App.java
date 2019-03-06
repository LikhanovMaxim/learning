package learning.java.core.hashCodesEquals;

import java.sql.Date;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 1 для одного и того-же объекта, хеш-код всегда будет одинаковым; 
 * 2 если объекты одинаковые, то и хеш-коды одинаковые (но не наоборот, см. правило 3). 
 * 3 если хеш-коды равны, то входные объекты не всегда равны (коллизия); 
 * 4 если хеш-коды разные, то и объекты гарантированно разные; 
 */
public class App {
	public static void main(String[] args) {

		System.out.println("Equals and hashCode:");
		A first = new A("asd", 1, null);
		A b = new A("asd", 1, null);
		System.out.println(first.equals(b));
		System.out.println(first.hashCode() == b.hashCode());

		System.out.println("Only equals:");
		OnlyEquals onlyEquals = new OnlyEquals("ads", 1, new Date(123));
		OnlyEquals onlyEquals2 = new OnlyEquals("ads", 1, new Date(123));
		System.out.println(onlyEquals.equals(onlyEquals2));
		System.out.println(onlyEquals.hashCode() == onlyEquals2.hashCode());

		Map<String, OnlyEquals> hashmap = new HashMap<>();
		hashmap.put("ss1", onlyEquals);
		hashmap.put("ss1_2", onlyEquals);
		hashmap.put("ss2", onlyEquals2);
		hashmap.put("ss2_2", onlyEquals2);
		System.out.println(Arrays.toString(hashmap.entrySet().toArray()));
		System.out.println(hashmap);
//		System.out.println(hashmap.get("ss1") == hashmap.get("ss2"));
//		System.out.println(hashmap.get("ss1").hashCode() == hashmap.get("ss2").hashCode());
//		System.out.println(hashmap.get("ss1").equals(hashmap.get("ss2")));
	}
}

class OnlyEquals{
	private String a;
	private Integer b;
	private Object d;

	public OnlyEquals(String a, Integer b, Object d) {
		this.a = a;
		this.b = b;
		this.d = d;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		OnlyEquals that = (OnlyEquals) o;
		return Objects.equals(a, that.a) && Objects.equals(b, that.b) && Objects.equals(d, that.d);
	}

}

class A {
	private String a;
	private Integer b;
	private List<String> strings;

	public A(String a, Integer b, List<String> strings) {
		this.a = a;
		this.b = b;
		this.strings = strings;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		A a1 = (A) o;
		return Objects.equals(a, a1.a) && Objects.equals(b, a1.b) && Objects.equals(strings, a1.strings);
	}

	@Override
	public int hashCode() {
		return Objects.hash(a, b, strings);
	}
}