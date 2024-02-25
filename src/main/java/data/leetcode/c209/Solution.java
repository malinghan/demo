package data.leetcode.c209;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2023-12-09
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其总和大于等于 target 的长度最小的
 * 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * 双指针方法
 * 时间复杂度 O(n)
 * 空间复杂度 O(1)
 */
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // >= target,
        // sum[j] - sum[i] >= target 且 j-i最小
        //n 个正整数
        int i = 0, j = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = nums[0];
        while (j < nums.length && i <= j) {
            while (j < nums.length  && sum < target) {
                j++;
                if (j < nums.length) {
                    sum += nums[j];
                }
            }
            if(sum >= target) {
                minLen = Math.min(minLen, j-i+1);
            }
            sum -= nums[i];
            i++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}