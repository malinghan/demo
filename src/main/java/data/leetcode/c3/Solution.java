package data.leetcode.c3;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2023-12-06
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int  i = 0;
        int j = 0;
        int maxLen = 0;
        while(j < s.length()) {
            int index =   containIndex(s, i , j);
            if (index != -1) {
                i = index+1;
            }
            maxLen = Math.max(maxLen, j-i+1);
            j++;
        }
        return maxLen;
    }

    int containIndex(String s, int i , int j) {
        while(i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
    }
}
