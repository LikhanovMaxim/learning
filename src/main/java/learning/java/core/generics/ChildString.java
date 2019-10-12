package learning.java.core.generics;

public class ChildString extends Parent {

    @Override
    <T> T gettingClass(T o) {
        return (T) super.gettingClass(String.class);
    }
}
