package data.leetcode.c26;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2023-12-01
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0;
        //非严格递增
        while (j < nums.length) {
            if (nums[j] != nums[i]) {
                nums[i+1] = nums[j];
                i++;
            }
            j++;
        }
        return i+1;
    }
}
