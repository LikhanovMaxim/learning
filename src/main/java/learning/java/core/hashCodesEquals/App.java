package learning.java.core.hashCodesEquals;

import java.sql.Date;
import java.util.*;

/**
 * 1 для одного и того-же объекта, хеш-код всегда будет одинаковым; 
 * 2 если объекты одинаковые, то и хеш-коды одинаковые (но не наоборот, см. правило 3). 
 * 3 если хеш-коды равны, то входные объекты не всегда равны (коллизия); 
 * 4 если хеш-коды разные, то и объекты гарантированно разные; 
 */
public class App {
    public static void main(String[] args) {
        final Object obj1 = new Object();
        final Object obj2 = new Object();

        System.out.println(obj1.equals(obj2)); // 1
        System.out.println(obj1 == obj2); // 2

        final String str1 = new String("string");
        final String str2 = new String("string");

        System.out.println(str1.equals(str2)); // 3
        System.out.println(str1 == str2);     // 4

        final String str3 = "string";
        final String str4 = "string";
        final String str5 = "str" + "ing";

        System.out.println(str3.equals(str4)); // 5
        System.out.println(str3 == str4);     // 6
        System.out.println(str3 == str5);     // 7
        System.out.println("Equals and hashCode:");
//        equalsAndHashCode();

        System.out.println("Only equals:");
        onlyEquals();
//		System.out.println(hashmap.get("ss1") == hashmap.get("ss2"));
//		System.out.println(hashmap.get("ss1").hashCode() == hashmap.get("ss2").hashCode());
//		System.out.println(hashmap.get("ss1").equals(hashmap.get("ss2")));
    }

    private static void equalsAndHashCode() {
        EqualsAndHashCode first = new EqualsAndHashCode("asd", 1, null);
        EqualsAndHashCode second = new EqualsAndHashCode("asd", 1, null);
        EqualsAndHashCode third = new EqualsAndHashCode("asd", 2, null);
        System.out.println(first.equals(second));
        System.out.println(first.hashCode() == second.hashCode());
        System.out.println(first.hashCode() == third.hashCode());
    }

    private static void onlyEquals() {
        OnlyEquals onlyEquals = new OnlyEquals("ads", 1, new Date(123));
        OnlyEquals onlyEquals2 = new OnlyEquals("ads", 1, new Date(123));
        OnlyEquals onlyEquals3 = new OnlyEquals("xxx", 1, new Date(123));


//        OnlyEqualsChild child = new OnlyEqualsChild("ads", 1, new Date(123), "das");
//        System.out.println(onlyEquals.equals(child));
        System.out.println(onlyEquals.equals(onlyEquals2));
        System.out.println(onlyEquals.hashCode() == onlyEquals2.hashCode());

        Set<OnlyEquals> set = new HashSet<>();
        set.add(onlyEquals);
        set.add(onlyEquals2);

//        Should be one, but will be two:
        System.out.println("Print set: " + set);
//        Map<String, OnlyEquals> hashmap = new HashMap<>();
//        hashmap.put("ss1", onlyEquals);
//        hashmap.put("ss1_2", onlyEquals);
//        hashmap.put("ss2", onlyEquals2);
//        hashmap.put("ss2_2", onlyEquals2);
//        System.out.println(Arrays.toString(hashmap.entrySet().toArray()));
//        System.out.println(hashmap);
    }
}

class OnlyEquals {
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

class OnlyEqualsChild extends OnlyEquals {

    String string;

    public OnlyEqualsChild(String a, Integer b, Object d, String string) {
        super(a, b, d);
        this.string = string;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}

class EqualsAndHashCode {
    private String a;
    private Integer b;
    private List<String> strings;

    public EqualsAndHashCode(String a, Integer b, List<String> strings) {
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
        EqualsAndHashCode equalsAndHashCode1 = (EqualsAndHashCode) o;
        return Objects.equals(a, equalsAndHashCode1.a) && Objects.equals(b, equalsAndHashCode1.b) && Objects.equals(strings, equalsAndHashCode1.strings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, strings);
    }
}