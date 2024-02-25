package data.leetcode.c53;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2023-12-09
 */
public class Solution1 {
    public int maxSubArray(int[] nums) {
        int[] sum = new int[nums.length];
        int[] prefix_min = new int[nums.length];
        sum[0] = nums[0];
        prefix_min[0] = 0;
        int[] max = new int[nums.length];
        max[0] = nums[0];
        for(int i = 1;i < nums.length; i++) {
            sum[i] = sum[i-1] + nums[i];
            prefix_min[i]  = Math.min(prefix_min[i-1], sum[i-1]);
            max[i] = sum[i] - prefix_min[i];
        }
        int res = max[0];
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res, max[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
