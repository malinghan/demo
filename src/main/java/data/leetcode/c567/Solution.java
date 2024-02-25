package data.leetcode.c567;

import java.util.Arrays;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2023-12-06
 */
public class Solution {
    //给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
    //
    //换句话说，s1 的排列之一是 s2 的 子串 。
    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[26];
        int[] count1  = new int[26];
        if (s2.length() < s1.length())  {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count1[s2.charAt(i) - 'a']++;
        }
        for (int j = 0; j < s2.length() - s1.length() + 1; j++) {
            if(Arrays.equals(count, count1)) {
                return true;
            }
            if (j + s1.length() - 1!= s2.length() - 1 ) {
                count1[s2.charAt(j) - 'a']--;
                count1[s2.charAt(j + s1.length()) - 'a']++;
            }
        }
        return false;
    }
}
