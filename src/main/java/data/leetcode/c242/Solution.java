package data.leetcode.c242;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2023-12-01
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] code = new char[26];
        for (int i = 0; i < s.length(); i++) {
            code[s.charAt(i) - 'a'] ++;
            code[t.charAt(i) - 'a'] --;
        }
        for (char c : code) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}
