package data.leetcode.c239;

import java.util.Arrays;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2023-12-08
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 * 提示：
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 *
 * 0  1 2 3 4  ///2
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l = 0;
        int maxIndex = 0;
        int[] res = new int[nums.length - k+1];
        maxIndex = findMax(nums, 0,  k-1);
        res[0] = nums[maxIndex];
        while (l + k -1 < nums.length-1) {
            l++;
            if (l <= maxIndex) {
                if (nums[maxIndex] <= nums[l+k-1]) {
                    maxIndex = l+k-1;
                }
            } else {
                maxIndex = findMax(nums, l,  l+ k-1);
            }
            res[l] = nums[maxIndex];
        }
        return res;
    }

    int findMax(int[] nums, int  i, int j) {
        int maxIndex = i;
        for (int m = i; m <= j; m++) {
            if (nums[maxIndex] <= nums[m]) {
                maxIndex = m;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
    }
}
