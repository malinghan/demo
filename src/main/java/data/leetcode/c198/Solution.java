package data.leetcode.c198;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-07
 */
public class Solution {
    public int rob(int[] nums) {
        // amount[i] = amount[i-2] + nums[i]
        // amount[i] = amoint[i-3] + nums[i]
        //  i-4  i-3  i-2  i-1  i
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0] , nums[1]);
        }
        if (n == 3) {
            return Math.max(nums[0] + nums[2], nums[1]);
        }
        int [] amount = new int[n];
        //    amount[0] = nums[0];
        //    amount[1] = nums[1];
        //    amount[2] = nums[0] + nums[2];
        int maxAmount = 0;
        for(int i = 0; i < n; i++) {
            if (i < 2) {
                amount[i] = nums[i];
            }else if(i == 2) {
                amount[i] = nums[0] + nums[2];
            } else {
                amount[i] = Math.max(amount[i-2] + nums[i], amount[i-3] + nums[i]);
            }
            maxAmount = Math.max(maxAmount, amount[i]);
        }
        return maxAmount;
    }
}