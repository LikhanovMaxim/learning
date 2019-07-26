package learning.java.core.immutable;

/**
 * Immutable objects
 * . "Strings" because
 * it is save memory by String Pool;
 * it is secure: login & password are strings, if we could change them it will be dangerous
 *
 * . Integer, Byte, Character, Short, Boolean, Long, Double, Float, BigInteger, BigDecimal
 */
public class App {
    public static void main(String[] args) {
        exampleStrings();
        exampleStrings2();
        exampleWrappers();
        exceptions();
    }

    /**
     * @see java.lang.StackTraceElement
     */
    private static void exceptions() {
        //Представь, что кто-нибудь заходит в StackTrace и меняет OutOfMemoryError на FileNotFoundException.
        //А тебе с этим стеком работать и искать причину ошибки. А программа при этом вообще не использует файлы :)
        // Поэтому от греха подальше эти объекты сделали неизменяемыми.
    }

    /**
     * Integer, Byte, Character, Short, Boolean, Long, Double, Float — все эти классы создают Immutable объекты.
     * Сюда же относятся и классы, используемые для создания больших чисел — BigInteger и BigDecimal.
     */
    private static void exampleWrappers() {
        System.out.println("example wrappers");
        Integer a = 10;
        Integer b = a;
        System.out.println("b:" + b);
        a = 20;
        System.out.println("b:" + b);
        System.out.println("a:" + a);
    }

    private static void exampleStrings() {
        String str1 = "I love Java";

        String str2 = str1;//обе переменные-ссылки указывают на одну строку.
        System.out.println(str2);

        str1 = "I love Python";//но поведение str1 никак не влияет на str2
        System.out.println(str2);//str2 продолжает указывать на строку "I love Java", хотя str1 уже указывает на другой объект
        System.out.println("str1: " + str1);//

    }

    private static void exampleStrings2() {
        System.out.println("second example");
        String str1 = "I love Java";

        String str2 = str1;//обе переменные-ссылки указывают на одну строку.
        System.out.println(str2);

        String str1AfterReplacement = str1.replace("Java", "Python");
        System.out.println(str2);

        System.out.println(str1AfterReplacement);
    }
}
