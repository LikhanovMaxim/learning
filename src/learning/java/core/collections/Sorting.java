package learning.java.core.collections;

import java.text.Collator;
import java.util.Arrays;
import java.util.List;

public class Sorting {
    public static void main(String[] args) {
        sortAlphabet1();
        sortAlphabet2();
        sortAlphabet3();

    }

    private static void sortAlphabet3() {
        List<PersonSort> list = Arrays.asList(
                new PersonSort("vendor", 21),
                new PersonSort("collection_top", 54));
        list.sort((a, b) -> a.getName().compareToIgnoreCase(b.getName()));
        System.out.println(list);
    }

    private static void sortAlphabet2() {
        List<String> list = Arrays.asList("Venod", "abc");
        list.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println(list);
    }

    private static void sortAlphabet1() {
        List<String> list = Arrays.asList("venod", "abc");
        list.sort(Collator.getInstance());
        System.out.println(list);
    }
}
