package learning.codility.cracking;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class StringArrayExamples {


    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        for (String elemnt : list) {
//            if(i = 0) {
//                list.re
//            }
        }
        ListIterator<String> iterator = list.listIterator();
        ListIterator<String> iterator2 = null;
        while (iterator.hasNext()) {
            String a = iterator.next();
            if (a == "1") {
                iterator.remove();
            }
        }
        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
//            list.
        }


    }
}
