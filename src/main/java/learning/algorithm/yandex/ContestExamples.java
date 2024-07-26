package learning.algorithm.yandex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class ContestExamples {

    /**
     * https://contest.yandex.ru/contest/8458/problems/A/
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {

//        String j = "ab";
//        String s = "aabbccd";
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        String j = r.readLine();
        String s = r.readLine();
        solution(j, s);
    }

    private static void solution(String j, String s) {
        Set<String> jewelry = new HashSet<>();
        for (int i = 0; i < j.length(); i++) {
            jewelry.add(String.valueOf(j.charAt(i)));
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (jewelry.contains(String.valueOf(s.charAt(i)))) {
                count++;
            }
        }
        System.out.println(count);
    }

    static int findMaxSequenceTrue(boolean[] arr) {
        int max = -1;
        int cur = 0;
        for (boolean b : arr) {
            if (b) {
                cur++;
            } else {
                max = Math.max(cur, max);
                cur = 0;
            }
        }
        max = Math.max(cur, max);
        System.out.println(max);
        return max;
    }

    static List<Integer> removeDuplicates(int[] arr) {
        LinkedList<Integer> result = new LinkedList<>();
        result.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != result.getLast()) {
                result.add(arr[i]);
            }
        }
        return result;
    }

    static List<Integer> removeDuplicates2(List<Integer> arr) {
        ListIterator<Integer> iterator = arr.listIterator();
        int last = iterator.next();
        while (iterator.hasNext()){
            Integer cur = iterator.next();
            if (last != cur){
                last = cur;
            } else {
                iterator.remove();
            }
        }

//        for (int i = 1; i < arr.size(); i++) {
//            Integer cur = arr.get(i);
//            if (cur != last) {
//                last = cur;
//            } else{
//                arr.remove(i);
//            }
//        }
        return arr;
    }
}
