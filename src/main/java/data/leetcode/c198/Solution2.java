package data.leetcode.c198;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-07
 */
public class Solution2 {
    public int rob(int[] nums) {
        //前 i间房屋能偷窃到的最高总金额
        // amount[i] = Math.max(amount[i-2] + nums[i], amount[i-1])
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int p = nums[0];
        int q = Math.max(nums[0],nums[1]);
        // p q
        //   temp
        //    p   q
        for(int i = 2; i < n; i++) {
            int temp = q;
            q = Math.max(p + nums[i], q);
            p = temp;
        }
        return q;
    }
}