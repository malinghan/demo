package data.leetcode.c1793;

class Solution {
    public int maximumScore(int[] nums, int k) {
        //双指针移动？
        //动态规划

        // nums
        // k  子数组的区间必须包含k
        // left = k-1;  <-
        // right = k+1;  ->
        // 计算 min
        // 计算 score
        // 0 <= k < nums.length
        int n = nums.length;
        int left = k-1;
        int right = k+1;
        int ans = 0;
        int min = nums[k];
        while(left >= 0 || right <= n) {
            //min不变的情况下，left--,
            while (left >= 0 && nums[left] >= min) {
                left--;
            }
            //min不变的情况下，right++,
            while (right <= n-1 && nums[right] >= min) {
                right++;
            }
            //此时left right都在边界以外
            ans = Math.max(ans, min * (right - left +1 -2));
            if (left == -1 && right == n) {
                break;
            }
            if (left != -1 && right != n) {
                min = Math.max(nums[left], nums[right]);
            } else if (left == -1) {
                min = nums[right];
            } else {
                min = nums[left];
            }
        }
        return ans;
    }
}