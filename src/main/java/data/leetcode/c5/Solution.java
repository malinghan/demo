package data.leetcode.c5;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2023-12-01
 */
public class Solution {
    public String longestPalindrome(String s) {
        int maxLen = 0;
        String max = "";
        for (int i = 0; i < s.length(); i++) {
           String s1 = palindrome(s,i, i);
            String s2 = palindrome(s,i, i+1);
            maxLen = Math.max(maxLen, Math.max(s1.length(), s2.length()));
            max = max.length() > s1.length() ? max : s1;
            max = max.length() > s2.length() ? max : s2;
        }
        return max;
    }

    /**
     * 输入字符串和下标，输出该下标为中心的回文串
     * @param s
     * @param l,r
     * @return
     */
    String palindrome(String s, int l, int r) {
         int i = l;
         int j = r;
         while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
             i--;
             j++;
         }
         //substring的特质,左闭右开
         return s.substring(i+1, j);
    }
}
