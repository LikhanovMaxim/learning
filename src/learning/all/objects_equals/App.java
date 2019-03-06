package learning.all.objects_equals;

import java.util.Objects;

public class App {

    public static void main(String[] args) {
        String a = null;
        String b = null;
        boolean res = Objects.equals(a, b);
        System.out.println(res);

        System.out.println(Objects.isNull(a));
    }
}
