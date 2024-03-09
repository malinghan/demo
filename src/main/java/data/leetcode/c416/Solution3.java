package data.leetcode.c416;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-09
 */
public class Solution3 {
        public boolean canPartition(int[] nums) {
            // 每一行只与上一行的dp值有关,将dp降低维度
            // dp[j] = dp[j] | dp[j - nums[i]]
            // 第二层需要从大到小计算:
            int n = nums.length;
            if (n < 2) {
                return false;
            }
            int sum = 0, maxNum = 0;
            for (int num : nums) {
                sum += num;
                maxNum = Math.max(maxNum, num);
            }
            if (sum % 2 != 0) {
                return false;
            }
            int target = sum / 2;
            if (maxNum > target) {
                return false;
            }
            boolean[] dp = new boolean[target + 1];
            dp[0] = true;
            for (int  i = 0; i < n; i++) {
                int num = nums[i];
                for(int j = target; j >= num; j--) {
                    dp[j] = dp[j] | dp[j -num];
                }
            }
            return dp[target];
        }
    public static void main(String[] args) {
        new Solution1().canPartition(new int[]{1,1,2,2});
    }
    }

// i = 0  j target  dp[target] = dp[target] | dp[j - num] = dp[j - num]
