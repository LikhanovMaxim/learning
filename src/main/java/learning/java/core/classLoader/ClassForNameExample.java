package learning.java.core.classLoader;

import java.lang.reflect.Method;

public class ClassForNameExample {

    //    class from bootstrap rt.jar
    public static final String JAVA_AWT_POINT = "java.awt.Point";

    public static void main(String[] args) {
        classForName();
        classLoader();
//        TODO what is the diff?  https://javatutorial.net/java-class-loaders-explained
    }

    private static void classForName() {
        Class<?> c = null;
        try {
            c = Class.forName(JAVA_AWT_POINT);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        printInfoClass(c);
    }

    private static void printInfoClass(Class<?> c) {
        if (c == null) {
            return;
        }
        System.out.println("name = " + c.getName());
        System.out.println("package = " + c.getPackage());
        Method[] methods = c.getDeclaredMethods();
        System.out.println("----- Class methods ---------------");
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }

    private static void classLoader() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class<?> c = null;
        try {
            c = classLoader.loadClass(JAVA_AWT_POINT);
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
            e.printStackTrace();
        }
        printInfoClass(c);
    }
}
