package learning.java.core.java8;

@FunctionalInterface
public interface Example {
    void epta();

    default void petuh(){
        System.out.println("Ha!");
    }
}
