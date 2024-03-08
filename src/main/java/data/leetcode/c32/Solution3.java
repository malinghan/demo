package data.leetcode.c32;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-07
 */
public class Solution3 {
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxLen = 0;
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                maxLen = Math.max(maxLen, 2 * right);
            }  else if (right > left) {
                left = 0;
                right = 0;
            }
        }
        left = right = 0;
        for(int i = s.length() -1; i >= 0 ; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                maxLen = Math.max(maxLen, 2 * left);
            }  else if (left > right) {
                left = 0;
                right = 0;
            }
        }
        return maxLen;
    }
}
