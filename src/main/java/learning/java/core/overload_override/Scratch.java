package learning.java.core.overload_override;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * binding static vs dynamic
 */
class Scratch {

    public static void main(String[] args) {
        Test scratch = new Test();
    }
}

class Test {

    public Test() {
        Collection c = new HashSet();
        //so it is dynamic binding
        print(c);
    }

    public void print(Collection c) {
        System.out.println("Collection");
    }

    public void print(Set s) {
        System.out.println("Set");
    }

    public void print(HashSet hs) {
        System.out.println("HashSet");
    }
}
