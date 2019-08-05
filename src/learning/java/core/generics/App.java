package learning.java.core.generics;

public class App {

    public static void main(String[] args) {
        ChildString childString = new ChildString();

//        childString.gettingClass()
        gettingClass(new Integer(10));
    }


    static <T> T gettingClass(T o) {
        System.out.println(o.getClass());
        return (T) o;
    }
}
