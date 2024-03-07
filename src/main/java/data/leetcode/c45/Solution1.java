package data.leetcode.c45;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-07
 * 从后往前遍历，
 * 每次都需要从0开始计算起点，复杂度 O(n^2)
 */
public class Solution1 {
    //最小跳跃次数
     public int jump(int[] nums) {
        int n = nums.length;
        int steps = 0;
        int position = n -1;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                  if (i + nums[i]  >= position) {
                      position = i;
                      steps ++;
                      break;
                  }
                }
        }
        return steps;
     }
}
