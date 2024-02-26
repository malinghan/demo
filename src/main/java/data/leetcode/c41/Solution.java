package data.leetcode.c41;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-26
 */
public class Solution {
    public static int firstMissingPositive(int[] nums) {
        int  n = nums.length;
        //1. 将负数变为 n+1
        for (int i = 0; i < n; i++) {
            if ( nums[i] <= 0) {
                nums[i] = n+1;
            }
        }
        //2.将正数变负数，挖坑法
        for (int j = 0; j < n; j++) {
              //绝对值
              int abs = Math.abs(nums[j]); //?? 避免循环, 保存真实值
              if (abs <= n) {
                  nums[abs-1] = - Math.abs(nums[abs-1]);
              }
        }

        //// 遍历数组找到第一个正数的下标，即为缺失的第一个正数
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n+1;
    }
}
