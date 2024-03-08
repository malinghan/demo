package data.leetcode.c5;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-08
 */
public class Solution2 {
        public String longestPalindrome(String s) {
            String res = s.charAt(0) + "";
            for(int i = 0; i < s.length()-1; i++) {
                String s1 = palindrome(s,i,i);
                String s2 = palindrome(s, i,i+1);
                String temp = s1.length() > s2.length() ? s1 : s2;
                res = res.length() > temp.length() ? res : temp;
            }
            return res;
        }

        /**
         * 返回以i,j为起点扩展的最长子串
         */
        String palindrome(String s, int i ,int j) {
            while(i >= 0 && j <s.length() && s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            }
            return s.substring(i+1, j);
        }
}