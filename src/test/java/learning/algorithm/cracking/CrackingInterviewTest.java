package learning.algorithm.cracking;

import org.junit.jupiter.api.Test;

import java.util.HashMap;


class CrackingInterviewTest {

    @Test
    public void testRecursive() {
        CrackingInterview crackingInterview = new CrackingInterview();
        int f = crackingInterview.f(5);
        System.out.println("result" + f);
        System.out.println("invokes:" + crackingInterview.count);
        //it will be O(2^N) not O(n^2). In this example =31, not 25
    }

    @Test
    public void test() {
        HashMap<String, Integer> table = new HashMap<>();
        String key = "first";
        table.put(key, 1);//init

        table.replace(key, table.get(key) + 1);
    }

}
