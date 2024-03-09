package data.leetcode.c416;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-09
 */
public class Solution1 {
    public boolean canPartition(int[] nums) {
        // 2个子集元素和相等，假定sum
        // 如果是奇数， 无解
        // 如果是偶数， sum/2
        // 错误思路: 先排序，再前缀和查找？二分查找？ 反例: [1,1,2,2]
        // 什么是0-1背包问题？给定一个数组和一个容量为x的背包，求有多少种方式让背包装满（有多少种子集能让子集之和等于背包容量）
        // 背包定义: 数组 nums, 容量 x  = sum/2, 是否可以达到装满
        // 关键词：子集，和，动态规划
        // 1. 如何定义dp状态: boolean[][] dp[i][j] 表示: 从nums(0~i)选一些元素使得背包内总和为j时，是否存在解
        // 2. 如何定义dp方程:
        //     当 j >= nums[i]时 dp[i][j] = dp[i-1][j] 为true[不选i] 或者 dp[i-1][j - num[i]] 为true[选i]
        //     当 j < nums[i]时  dp[i][j] = dp[i-1][j]
        // 3. 如何遍历: 外层: i: 1->n   内层: j(sum):1 -> target
        // 4. 如何初始化:
        //      dp[i][0] = true; 表示不选，使得target = 0
        //     dp[0][nums[0]] = true; 表示选nums[0], 使得target= nums[0];
        // 5. 如何获取结果   dp[n-1][target]
        // 6. 复杂度 O(n * target)
        int n = nums.length;
        int sum = 0;
        int maxNum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            maxNum = Math.max(nums[i], maxNum);
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum /2;
        if (maxNum > target) {
            return false;
        }
        //设dp[i][j] 为前i个数中选择一些数，使得总和为j，是否存在
        boolean[][] dp = new boolean[n][target+1];
        //初始化第一列
        for(int i = 0 ; i < n; i++) {
            dp[i][0] = true;
        }
        //初始化第一行
        dp[0][nums[0]] = true;
        //递推
        for(int i = 1; i < n; i++) {
            for(int j = 1; j <= target; j++) {
                int num = nums[i];
                if (num <= j) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j- num];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n-1][target];
    }

    public static void main(String[] args) {
        new Solution3().canPartition(new int[]{1,1,2,2});
    }
}