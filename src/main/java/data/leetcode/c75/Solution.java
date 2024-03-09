package data.leetcode.c75;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-09
 */
class Solution {
    public void sortColors(int[] nums) {
        //把0往左移动，2往右移动，1不管
        int n = nums.length;
        if (n  == 1) {
            return;
        }
        int p = 0;
        for (int i = 0 ; i < n; i++) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p];
                nums[p] = temp;
                p++;
            }
        }
        for (int i = p ; i < n; i++) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[p];
                nums[p] = temp;
                p++;
            }
        }
    }
}
