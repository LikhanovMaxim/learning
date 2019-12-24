package learning.java.core.classLoader;

public class App {
    public static void main(String[] args) {
        String s = "asd";
        System.out.println(s);
        System.out.println(String.class.getClassLoader());
    }
}
