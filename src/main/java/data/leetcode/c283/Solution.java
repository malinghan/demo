package data.leetcode.c283;

/**
 * 双指针
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2023-12-01
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        //一个指针标记
        //一个指针移动
        //到底是找0，还是非0？
        //染色法
        int target = 0;
        int index = paintColor(nums, target);
        for(int i = index; i < nums.length; i++) {
            nums[i] = target;
        }
    }

    /**
     * 多染了 i~j
     * @param nums
     * @param target
     * @return
     */
    int paintColor(int[] nums, int target) {
        int  i = 0;
        for(int j = 0; j < nums.length; j++) {
            if (nums[j] != target) {
                int k = j;
                int color = nums[j];
                while(k>= i) {
                    nums[k] = color;
                    k--;
                }
                i++;
            }
        }
        return i;
    }

    /**
     * 只染i
     * @param nums
     * @param target
     * @return
     */
    int paintColor2(int[] nums, int target) {
        int  i = 0, j = 0;
        while(j < nums.length) {
            if (nums[j] != target) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }
}
