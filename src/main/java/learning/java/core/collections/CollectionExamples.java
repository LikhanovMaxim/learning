package learning.java.core.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionExamples {

    //example .ConcurrentModificationException
    // change collection when iterate
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        for (Integer integer : list) {
            System.out.println(integer);
            list.remove(1);
        }
    }
}
