package learning.java.core.keywords._final;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChildTest {

    @Test
    void shouldInvokeParentConstructor() {
        Child child = new Child();
        System.out.println(child);
    }

    @Test
    void shouldInvokeAnotherConstructorWhenUseSuper() {
        Child child = new Child(2);
        System.out.println(child);
    }
    @Test
    void shouldInvoke() {
        Child child = new Child();
        child.lol();
    }
}
