package data.leetcode.c189;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-26
 */
public class Solution2 {
    public static void rotate(int[] nums, int k) {
        reverse(nums, 0 , nums.length);
        reverse(nums, 0 , k-1);
        reverse(nums, k , nums.length);
    }

    public static void reverse(int[] nums, int  i , int j) {
        while ( i <= j ) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
