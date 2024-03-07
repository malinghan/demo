package data.leetcode.c300;

import java.util.Arrays;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-07
 * 问题1：定义错误
 * 给定 f[i] 表示：以i为结束点的最长递增子序列长度
 * 问题2: f[i] = f[i-1] 不成立
 * 应该是: 可能存在j，使得 f[i] = f[j] +1  其中，j是通过循环遍历数组(0~i-1)比较得找到的值
 * 问题3: max = f[n-1]
 * 应该是： max = Math.max(max, f[i]);
 * 正确解法见 solution1
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        //给出最长递增子序列的长度
        //给定 f[i] 以i以前的最长递增子序列长度
        // f[i] = f[i-1] or 1
        // 初始化 全为1
        int n = nums.length;
        int[] f = new int[n];
        Arrays.fill(f,1);
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i-1]) {
                f[i] = f[i-1] +1;
            } else {
                //寻找比他小的元素，找不到
                int j = i-1;
                while(j >= 0 && nums[i] >= nums[j]) {
                    j--;
                }
                if (j >= 0) {
                    f[i] = f[j] + 1;
                }
            }
        }
        return f[n-1];
    }
    //[4,10,4,3,8,9]
    //f[0] = 1
    //f[1] = f[0] +1 =2
    //f[2] = f[] = 1
    //f[3] = f[] = 1
    //f[4] = f[3] = 2
    //f[5] = f[4] = 3
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}