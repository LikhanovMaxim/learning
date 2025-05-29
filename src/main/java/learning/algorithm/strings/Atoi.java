package learning.algorithm.strings;

public class Atoi {

    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/884/
    /*
    todo new idea

     */
    public int myAtoi(String s) {

        return -1;
    }

    //todo smth strange. Maybe cause conditions in task
    public int myAtoi2(String s) {
        StringBuilder res = new StringBuilder("");
        int result = 0;
        int multiple = 1;
        int sign = 1;
        boolean digital = false;
        boolean firstSpaces = true;
        for (int i = 0; i < s.length(); i++) {
            if (firstSpaces) {
                if (s.charAt(i) == ' ') {
                    continue;
                } else firstSpaces = false;
            } else {
                if (s.charAt(i) == ' ') {
                    break;
                }
            }
            for (int j = i; j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9'; j++) {
//                result += (symbol - '0') * multiple;
//                multiple *= 10;
                if (j - 1 >= 0 && s.charAt(j - 1) == '-') {
                    sign = -1;
                }
                res.append(s.charAt(j));
                digital = true;
            }
            if (digital) {
                break;
            }

        }
        String s1 = res.toString();
        if (s1.isEmpty()) {
            return 0;
        }
        long l = Long.parseLong(s1);
        if (l > Integer.MAX_VALUE || l < Integer.MIN_VALUE) {
            if (sign == 1) {
                return Integer.MAX_VALUE;
            } else return Integer.MIN_VALUE;
        } else return sign * Integer.parseInt(s1);
    }
}
