package data.leetcode.c2369;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-01
 */
class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        dp[1] = false;
        dp[2] = validTwo(nums[1], nums[0]);
        for(int i = 3; i <= n; i++) {
            if(i >= 2) {
                dp[i] = dp[i-2] && validTwo(nums[i-2],nums[i-1]);
            }
            if (i >= 3) {
                dp[i] = dp[i] || (dp[i-3] && validThree(nums[i-3],nums[i-2],nums[i-1]));
            }
        }
        return dp[n];
    }

    boolean validTwo(int num1, int num2) {
        return num1 == num2;
    }

    boolean validThree(int num1, int num2, int num3) {
        return (num1 == num2 && num2 == num3) ||
                (num1 + 1 == num2 && num2 +1 == num3);
    }
}
