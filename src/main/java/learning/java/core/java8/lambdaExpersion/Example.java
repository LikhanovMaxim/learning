package learning.java.core.java8.lambdaExpersion;

@FunctionalInterface
public interface Example {
    void epta();

    default void petuh() {
        System.out.println("Ha!");
    }

    default void asd() {

    }
}
