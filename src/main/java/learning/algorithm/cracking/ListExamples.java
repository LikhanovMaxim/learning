package learning.algorithm.cracking;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListExamples {


    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("a");
        list.add("a");
        list.add("c");
        list.add("c");
        list.add("b");
        list.add("b");
        list.sort(Comparator.naturalOrder());
        list.forEach(System.out::println);
//        Collections.sort(list, Comparator.naturalOrder());
        ListIterator<String> a = list.listIterator();
        ListIterator<String> b = list.listIterator();
        while (a.hasNext()){
            String cur = a.next();
            while (b.hasNext()) {
                String next = b.next();
//                if (cur)
            }
        }
     }
}
