package learning.java.core.classLoader;

/**
 * add to VM options -verbose:class
 */
public class Main {
    /**
     * Вывод показывает, что классы были загружены не в том порядке в котором были использованы.
     * Это обусловлено наследованием.
     */
    public static void main(String args[]) {
        C c = new C();
        B b = new B();
        A a = new A();
    }
}
