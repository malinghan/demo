package data.leetcode.c189;

import java.util.Arrays;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-26
 * 使用额外的数组
 * 将元素copy到 (i + k ) mod n 的位置
 * 时间复杂度： O(n)，其中 n 为数组的长度。
 * 空间复杂度： O(n)
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; i++) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr,0 , nums,0, n);
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        new Solution().rotate(new int[]{1,2,3,4,5,6,7} , 3);
    }
}
