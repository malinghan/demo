package data.leetcode.c80;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-24
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int  i = 2;
        int j = 2;
        while(j < nums.length) {
            if (nums[i-2] != nums[j]) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }

    public static void main(String[] args) {
        new Solution().removeDuplicates(new int[] {0,0,1,1,1,1,2,3,3});
    }
}
