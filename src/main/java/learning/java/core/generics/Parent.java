package learning.java.core.generics;

public abstract class Parent {

    <T> T gettingClass(T o) {
        System.out.println(o.getClass());
        return (T) o;
    }

}
