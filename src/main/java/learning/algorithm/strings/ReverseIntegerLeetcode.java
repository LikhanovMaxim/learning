package learning.algorithm.strings;

/*
Given a signed 32-bit integer x, return x with its digits reversed.
If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
Constraints:

-231 <= x <= 231 - 1

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
Example 1:
Input: x = 123
Output: 321
Example 2:
Input: x = -123
Output: -321
Example 3:
Input: x = 120
Output: 21
Example 4:
2^31 -1 -> 2_147_483_647
-2^31 ->  -2_147_483_648
1_111_111_999 -> 9_991_111_111
0 -> 0
021
12
123  = 321
-123 =-321
//xxxxxxxxxx > 2_147_483_647 ok // ?????????
//-xxxxxxxxx -> -2_147_483_648 NOT OK
 */
public class ReverseIntegerLeetcode {

    /*
    idea 1
    brute force
    sum=0
    fori i--
        take digit
        if(sum*10 + digit < sum){
            return 0
        }
        sum= sum *10 + digit
    if(x)<0 //todo edge case ???????
        sum*= -1;
    return sum;

    2)idea 2
    take String "-123123" "241243132"
    Integer.ParsInt
        catch return 0;
     */
    public static int reverse3(int x){
        StringBuilder s = new StringBuilder();
        if (x < 0) {
            s.append("-");
        }
        while (x != 0) {
            int digit = Math.abs(x % 10);
            s.append(digit);
            x /= 10;
        }
        int res = 0;
        try {
            res = Integer.parseInt(s.toString());
        } catch (Exception e){
            //nothing
            return res;
        }
        return res;
    }

    public static void main(String[] args) {
        int i = Integer.MAX_VALUE + 1;
        System.out.println(Integer.MAX_VALUE + 1);
        System.out.println(Integer.MAX_VALUE * 10);
        System.out.println(Integer.MAX_VALUE * 10 + 10);
        System.out.println(Integer.MIN_VALUE - 1);
        System.out.println(1 / 10);
//        System.out.println(Integer.parseInt("9888555666")); NumberFormatException
        System.out.println(Integer.parseInt("-123"));
        System.out.println(-193%10);
        System.out.println(-1%10);
        reverse2(-1);
        reverse3(-1);
    }

    public static int reverse(int x) {
        int sum = 0;
        boolean negative = false;
        if (x < 0) {
            negative = true;
            x *= -1;
        }
        while (x != 0) {
            int digit = x % 10;
            int newValue = sum * 10 + digit;
            if (newValue < sum) {
                return 0;
            }
            sum = newValue;
            x /= 10;
        }
        if (negative)
            return -1 * sum;
        return sum;
    }

    public static int reverse2(int x) {
        int sum = 0;
        boolean check = false;
        while (x != 0) {
            int digit = x % 10;
            int newValue;
            if (sum >= 0) {
                newValue = sum * 10 + digit;
                if (newValue < sum) {
                    return 0;
                }
            } else {
                newValue = sum * 10 - digit;
                if (newValue > sum) {
                    return 0;
                }
            }
            sum = newValue;
            if (!check) {
                if (x < 0) {
                    sum = sum * -1;
                }
                check = true;
            }
            x /= 10;
        }

        return sum;
    }

    public boolean isAnagram(String s, String t) {
        int[] count = new int[27];
        if(s.length()!=t.length()){
            return false;
        }
        for(int i=0; i<s.length(); i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) -'a']--;
        }
        for (int e : count) {
            if (e != 0) {
                return false;
            }
        }
        return true;
    }
}
