package learning.java.core.nested;

import lombok.Data;

/**
 * Nested classes:
 * --- Inner class (Вложенный класс):
 * ------- Member inner class (Простой внутренний класс);
 * ------- Local inner class (Локальный класс);
 * ------- Anonymous inner class (Анонимный класс).
 * --- Static nested class (Статический вложенный класс);
 */
public class App {
    public static void main(String[] args) {

    }
}

class Example {

    private String outField;
    static String staticCutField;

    void makeSmthWithNested() {
        Nested nested = new Nested();
        nested.example = "dd";
        StaticNested.smth(nested);
    }

    void methodLocal() {
        class Local {
            void local() {
                System.out.println("local" + outField);
            }
        }
        Local local = new Local();
        local.local();
        //for what? todo any real cases?
    }

    /**
     * cannot use static methods and fields
     */
    @Data
    class Nested {

        String example;

        void smth() {
            System.out.println("Can be access to any fields(private). It breaks encapsulation");
            if (outField == null) {
                example = "not null";
            }
        }
    }

    @Data
    class NestedSecond {
        String example;//it is another Nested.example

        void smth() {
            Nested nested = new Nested();
            nested.smth();
        }
    }

    @Data
    static class StaticNested {

        static void smth(Nested nested) {
            staticCutField = "only static access";
            System.out.println("static nested" + nested.example);
        }
    }
}
