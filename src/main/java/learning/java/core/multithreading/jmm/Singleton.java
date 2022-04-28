package learning.java.core.multithreading.jmm;

/**
 * https://habr.com/ru/post/129494/
 */
public class Singleton {
    /**
     * volatile for happens-before.
     * cause
     * 1) local_ptr = malloc(sizeof(Student)) // выделение памяти под сам объект;
     * 2) s = local_ptr // инициализация указателя;
     * 3) Student::ctor(s); // конструирование объекта (инициализация полей);
     * Таким образом, между вторым и третьим этапом возможна ситуация, при которой другой поток может получить
     * и начать использовать (на основании условия, что указатель не нулевой) не полностью сконструированный объект.
     */
    private static volatile Singleton instance;

    public static Singleton getInstance() {
        Singleton localInstance = instance;
        if (localInstance == null) {
            synchronized (Singleton.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Singleton();
                }
            }
        }
        return localInstance;
    }
}

//not lazy init:
enum Singleton2 {
    INSTANCE;
}

class Singleton3 {

    String d;

    public Singleton3(String test) {
        d = test;
    }

    public static class SingletonHolder {
        public static final Singleton3 HOLDER_INSTANCE = new Singleton3("test");
    }

    public static Singleton3 getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }

    public static void main(String[] args) {
        Singleton3 instance = Singleton3.getInstance();
        System.out.println(instance.d);
    }
}
