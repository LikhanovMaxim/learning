package learning.algorithm.strings;

import java.util.LinkedHashMap;
import java.util.Map;

public class Leetcode {
    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/879/
    //Write a function that reverses a string. The input string is given as an array of characters s.
    //Input: s = ["h","e","l","l","o"]
    //Output: ["o","l","l","e","h"]
    public void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < s.length / 2; i++, j--) {
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
        }
    }

    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/880/
    public int reverse(int x) {
//TODO
        return x;
    }

//    https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/881/
    //Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
//    Input: s = "leetcode"
//Output: 0
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char cur = charArray[i];
            Integer orDefault = map.getOrDefault(cur, 0);
            map.put(cur, orDefault + 1);
        }
        //todo why does it work?
//        for (Map.Entry<Character, Integer> e : map.entrySet()) {
//            if (e.getValue() == 1) {
//                return s.indexOf(e.getKey());
//            }
//        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(charArray[i]) == 1) {
                return i;
            }
        }
        return -1;
    }


    //    Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1
    //    if needle is not part of haystack.
//    https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/885/
//    Input: haystack = "sadbutsad", needle = "sad"
//      Output: 0
//    ssad
    public int strStr(String haystack, String needle) {
        char[] hay = haystack.toCharArray();
        char[] needleCharArray = needle.toCharArray();
        for (int i = 0; i < hay.length; i++) {
            int j = 0;
            for (int k = i; j < needleCharArray.length && k < hay.length; j++, k++) {
                if (hay[k] != needleCharArray[j]) {
                    break;
                }
            }
            if (j == needleCharArray.length) {
                return i;
            }
        }
        return -1;
    }
}
