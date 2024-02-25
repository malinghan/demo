package data.leetcode.c128;

import java.util.HashSet;
import java.util.Set;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2023-12-01
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxLen = 1;
        //HashSet set
        //key -> len
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int j = 0; j < nums.length; j++) {
            int len  = 0;
            int value = nums[j];
            //这一步至关重要，没有这一步，算法的复杂度就不是 O(n)
            if (set.contains(value - 1)) {
                continue;
            }
            while(set.contains(value)) {
                value++;
                len++;
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}
