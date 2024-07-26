package learning.algorithm.strings;

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

}
