package data.leetcode.c3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2023-12-06
 */
public class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int  i = 0;
        int j = 0;
        int maxLen = 0;
        Map<Character, Integer> map  = new HashMap<>();
        while(j < s.length()) {
            if(map.containsKey(s.charAt(j)) && i <= map.get(s.charAt(j))) {
                i = map.get(s.charAt(j)) + 1;
            }
            map.put(s.charAt(j), j);
            maxLen = Math.max(maxLen, j-i+1);
            j++;
        }
        return maxLen;
    }

//    int containIndex(String s, int i , int j) {
//        while(i < j) {
//            if (s.charAt(i) == s.charAt(j)) {
//                return i;
//            }
//            i++;
//        }
//        return -1;
//    }

    public static void main(String[] args) {
        System.out.println(new Solution1().lengthOfLongestSubstring("abcabcbb"));
    }
}
