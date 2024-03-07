package data.leetcode.c300;

import java.util.Arrays;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-07
 */
public class Solution1 {

    public int lengthOfLIS(int[] nums) {
        //给出最长递增子序列的长度
        //给定 f[i] 以i以前的最长递增子序列长度
        // f[i] = f[i-1] or 1
        // 初始化 全为1
        int n = nums.length;
        int[] f = new int[n];
        Arrays.fill(f,1);
        int max = 1;
        for (int i = 1; i < n; i++) {
            //寻找比他小的元素，找不到
            int j = i-1;
            while(j >= 0) {
                if (nums[i] > nums[j]) {
                    f[i] = Math.max(f[j] + 1, f[i]);
                }
                j--;
            }
            max = Math.max(max, f[i]);
        }
        return max;
    }
}
