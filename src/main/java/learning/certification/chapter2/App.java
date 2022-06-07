package learning.certification.chapter2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class App {

    public static void main(String[] args) {
        instanseof1();

        System.out.println("strings:");
        System.out.println("23" == "23");
        String s = new String("23");//for buffers when read bytes
        System.out.println("23" == s);
        System.out.println("23" == s.intern());
    }

    public void CastingPrimitiveValues() {
        short x = 10;
        short y = 3;
        //	short z = x * y;//Doesn't compile
        short z = (short) (x * y);
    }


    public void composed() {
        long x = 10;
        int y = 5;
//		y =  y * x; //doesn't compile
        y = y * (int) x;
        y *= x;
    }

    private static void instanseof1() {
        String s;
        String s2;
        List<Integer> list = new ArrayList<>();
        System.out.println(list instanceof List);
        System.out.println(list instanceof ArrayList);
        System.out.println(list instanceof Iterable);
        System.out.println(list instanceof Iterator); //false
        System.out.println(list instanceof Collection);
        System.out.println(list instanceof Comparable);//false
    }

    public static void cast() {
        byte a = 40, b = 50;
        byte sum = (byte) (a + b);
        System.out.println(sum);
    }
}
