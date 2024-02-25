package data.leetcode.c27;

import java.util.Arrays;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2023-12-01
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0,  j = 0;
        while (j < nums.length) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        System.out.println(Arrays.toString(nums));
        return i;
    }
    //2,4,3,2,2,8  i = 0, j =0
    //4,4,3,2,2,8  i= 0, j=1;  => i = 1, j =2
    //4,3,3,2,2,8  i = 1, j = 2 => i = 2, j =3
    //4,3,3,2,2,8  i = 2, j=4
    //4,3,3,2,2,8  i = 2, j =5
    //4,3,8,2,2,8  i = 3

    public static void main(String[] args) {
        new Solution().removeElement(new int[] {2,4,3,2,2,8}, 2);
    }
}
