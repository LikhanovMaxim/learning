package learning.algorithm.strings;

public class FindOneDiff {

    /*
    input: strings s, m
    output: true if m can be equal is s if we change one symbol
    false another cases

    examples: "abc", "abb" true
    - "aaa" "ddd" false
    "" ""
    null null
    "aa" "abbb"
    "ac" "a" -??
    todo find the task

   Примеры тестовых сценариев:
   first = "a", second = "b" -> true
   first = "ab", second = "b" -> true
        "aaa"   "baaa" |  "aaa" "abaa"
        "aac" "baaa" -
   first = "ab", second = "cb" -> true
   first = "ab", second = "ba" -> false

   three cases:
   1) validation when another
   2) when size diff = 1. need one remove or add
   3) when size length are same. need to find one diff
     */
    boolean findOneDiff(String s, String m) {
        if (s.length() != m.length()) {
            if (Math.abs(s.length() - m.length()) > 1)
                return false;
            //take less
            if (s.length() > m.length()) {
                String b = s;
                s = m;
                m = b;
            }
            int count = 0;
            for (int i = 0, j = 0; i < s.length(); j++) {
                if (s.charAt(i) == m.charAt(j)) {
                    i++;
                } else {
                    count++;
                    if (count > 1) {
                        return false;
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != m.charAt(i)) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
