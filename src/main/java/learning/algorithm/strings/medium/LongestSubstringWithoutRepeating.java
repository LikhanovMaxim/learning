package learning.algorithm.strings.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Given a string s, find the length of the longest substring without duplicate characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeating {


    /*
    has two pointers. left right
    has set unique
    - if new symbol add to set & move right pointer
        -- max value
    - else need to move left pointer to be set unique.
     */
    public int lengthOfLongestSubstring(String s) {
        return -1;
        //todo impl
    }


    //todo time limit
    /*
    1) bruteforce
    for(i)
        for j
            check Set that OK
            count++
        max = count
    2) abcab
    [1,2,3,]
    "aaa"
    1
    "a 23%^#@!&*(_)"

    Map<Symbol, Indexes>
    a - 1, 3
    b - 2
    c- 0
    ...
    if s.length = 0 then 0

    3)
    - find unique symbols
    - generate substings
    --- generate max size()
    - fori
        find max
    **/
    public int lengthOfLongestSubstringTimeLimit(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        Set<Character> symbols = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            symbols.add(s.charAt(i));
        }
        int max = 1;
        // for (int i = symbols.size(); i>1; i--) {
        // }
        List<String> substrings = generate(symbols);
        System.out.println(substrings);
        for (String check : substrings) {
            if (s.contains(check)) {
                max = Math.max(max, check.length());
            }
        }
        return max;
    }

    /**
     a b c
     [abc, acb, bac, bca, cab, cba]
     [ab ac ba bc ca cb]
     [a b c]

     convert to list.
     for i
     remove current symbol
     curent symbol + all generate();
     res.add(current + all generate)


     2) convert to list.
     for ()
     */
    public List<String> generate(Set<Character> symbols) {
        if (symbols.size() == 1){
            return symbols.stream().map(c -> String.valueOf(c)).toList();
        }
        List<String> res = new LinkedList<String>();
        for (Character c: symbols) {
            Set<Character> copy = new HashSet(symbols);
            copy.remove(c);
            List<String> all = generate(copy);
            for(String gen: all) {
                if (gen.length() == symbols.size() - 1) {
                    res.add(c + gen);
                }
                res.add(gen);
            }
        }
        return res;
    }
}
