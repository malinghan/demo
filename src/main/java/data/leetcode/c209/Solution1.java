package data.leetcode.c209;

import java.util.Arrays;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2023-12-09
 * 前缀和+二分查找
 * 因为这道题保证了数组中每个元素都为正，所以前缀和一定是递增的，这一点保证了二分的正确性。如果题目没有说明数组中每个元素都为正，这里就不能使用二分来查找这个位置了。
 */
public class Solution1 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] sums = new int[n+1];
        sums[0] = 0;
        sums[1] = nums[0];
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i-1] + nums[i];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            //表示右边界
            int temp_target = target + sums[i];
            int bound = Arrays.binarySearch(sums, temp_target);
            //说明没找到等于的
            if (bound < 0) {
                bound = -bound -1;
            }
            //说明存在
            if (bound <= n) {
                ans = Math.min(ans, bound - (i-1));
            }
            if (bound > n) {
                //说明 lower在最右边，说明，temp_target 无解
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
