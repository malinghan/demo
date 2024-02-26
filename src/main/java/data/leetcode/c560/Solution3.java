package data.leetcode.c560;

import java.util.HashMap;
import java.util.Map;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-26
 */
public class Solution3 {
    public int subarraySum(int[] nums, int k) {
        //给定一个前缀和map key: pre[i] or (pre[j] - k) 前缀和为key的次数 value: count
        Map<Integer, Integer> preMap = new HashMap<>();
        //初始化前缀和为0的次数为1
        preMap.put(0,1);
        int count = 0;
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (preMap.containsKey(pre - k)) {
                count +=  preMap.get(pre - k);
            }
            preMap.put(pre, preMap.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
