package learning.java.core.classLoader;

public class App {
    public static void main(String[] args) {
        String s = "asd";
        System.out.println(s);
        System.out.println(String.class.getClassLoader()); //TODO Why null?

        Example a = new Example();
        a.contextExample();
    }

}

class Example {

     void contextExample() {
        System.out.println(getClass().getClassLoader());
        System.out.println(ClassForNameExample.class.getClassLoader());
        System.out.println(Thread.currentThread().getContextClassLoader());
    }
}