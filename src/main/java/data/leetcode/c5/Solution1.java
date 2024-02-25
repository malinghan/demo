package data.leetcode.c5;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-24
 */
public class Solution1 {
    public String longestPalindrome(String s) {
        String res = "";
        String resB = "";
        for(int i = 0; i < s.length(); i++) {
            String resA = palindrome(s,i,i);
            String temp = "";
            if(i > 0) {
                resB  = palindrome(s,i-1,i);
            }
            if (resA.length() > resB.length()) {
                temp = resA;
            } else {
                temp = resB;
            }
            if (res.length() < temp.length()) {
                res = temp;
            }
        }
        return res;
    }


    String palindrome(String s, int l, int r) {
        int i = 0;
        int m = l; int  n = r;
        while(m >= 0 && n < s.length() && s.charAt(m) == s.charAt(n)) {
            m--;
            n++;
        }
        return s.substring(m+1,n);
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().longestPalindrome("bb"));
    }
}
