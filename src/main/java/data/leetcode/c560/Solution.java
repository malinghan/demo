package data.leetcode.c560;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2023-12-08
 */
public class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> prefixCountMap  = new HashMap<>();
        //这里为什么放(0,1)?
        //answer: 算法模拟的是 nums[i] - nums[j-1]， 由于 j-1小于0,所以模拟一个 nums[-1] = 0 的元素来方便计算
        prefixCountMap.put(0, 1);
        int pre = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            pre = pre + nums[i];
            if (prefixCountMap.containsKey(pre - k)) {
                count++;
            }
            prefixCountMap.put(pre, prefixCountMap.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().subarraySum(new int[]{-1,-1,1}, 2));
        System.out.println(new Solution().subarraySum(new int[]{3,4,-7,0,-3,1,4,2}, 7));
    }
}
