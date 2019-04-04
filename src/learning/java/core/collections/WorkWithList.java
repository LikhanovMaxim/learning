package learning.java.core.collections;

import java.util.ArrayList;
import java.util.List;

public class WorkWithList {
    public static void main(String[] args) {

        arrayList();
    }

    private static void arrayList() {
        List<Integer> list = new ArrayList<>();

        list.add(12);
        list.add(14);
        list.add(13);

        list.forEach(System.out::println);
    }
}
