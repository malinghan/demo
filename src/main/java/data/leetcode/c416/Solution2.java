package data.leetcode.c416;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-09
 */
public class Solution2 {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for(int item : nums){
                sum += item;
            }
            if(sum % 2 != 0) return false;
            int max = sum / 2;
            int[] dp = new int[max + 1];
            for(int i = 0; i < nums.length; i++){
                for(int j = max; j >= nums[i]; j--){
                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                }
            }
            return dp[max] == max;
        }
}