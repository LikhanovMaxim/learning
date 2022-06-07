package learning.java.core.keywords._static;

public class App {
    public static void main(String[] args) {
        StaticClass.doIt();
        StaticClass.count = 10;

        StaticClass staticClass = new StaticClass();
        staticClass.showCount();
        staticClass.doIt();
    }
}
