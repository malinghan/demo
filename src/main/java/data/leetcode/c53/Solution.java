package data.leetcode.c53;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2023-12-09
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        // i , j
        //int max = sums[j] - sums[i]
        // Sum[i] = Max (Sum[i-1] + nums[i],nums[i] )
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i = 1;i < nums.length; i++) {
            sum[i] = Math.max(nums[i],sum[i-1]+ nums[i]);
        }
        int max = sum[0];
        for(int j = 1;j < sum.length; j++) {
            max =  Math.max(max, sum[j]);
        }
        return max;
    }
}
