package learning.algorithm;

import java.util.HashSet;
import java.util.Set;

public class GenerateBraces {

    /*
    n=1 ()
    n-2 ()()
        (())
    n=3 ()()()
        (())()
        ()(())
        (()())
        ((()))
     */

    Set<String> generate(int n) {
        if (n == 1) {
            return Set.of("()");
        }
//        Set<String> result = generate(n - 1, res);

        Set<String> result = new HashSet<>();
        for (String e : generate(n - 1)) {
            result.add("()" + e);
            result.add(e + "()");
            result.add("(" + e + ")");
        }
        return result;

    }

    public static void main(String[] args) {
        GenerateBraces generateBraces =new GenerateBraces();
        Set<String> generate = generateBraces.generate(3);
        System.out.println(generate);
    }
}
