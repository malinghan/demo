package data.leetcode.c560;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-26
 */
public class Solution2 {
    public int subarraySum(int[] nums, int k) {
        // 给定一个map， value: sum[i]  key: sum[i] - k
        // 前缀和 sum[j] - sum[i] = k
        int[] sum = new int[nums.length+1];
        sum[0] = nums[0];
        for(int i = 1; i < sum.length; i++) {
            sum[i] = nums[i-1] + sum[i-1];
        }
        int count = 0;
        for(int l = 0; l < sum.length; l++) {
            for(int r = l+1; r < sum.length; r++) {
                if (sum[r] - sum[l] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}