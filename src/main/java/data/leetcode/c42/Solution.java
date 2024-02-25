package data.leetcode.c42;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2023-12-02
 */
public class Solution {
    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     */
    public int trap(int[] height) {
        // i  high_min[i] = Math.min(left_max[i], right_max[i])
        // wateMax = high_min[i] - high[i] (if: high_min[i] - high[i] > 0)
        //left_max[i] = Math.max(left_max[i-1], high[i-1])
        //right_max[j] = Math.max(right_max[j+1], high[j+1])
        // sum = Sum(water);
        int[] left_max = new int[height.length];
        int[] right_max = new int[height.length];
        left_max[0] = 0;
        right_max[height.length-1] = 0;
        for (int i = 1; i < height.length; i++) {
            left_max[i] = Math.max(left_max[i-1], height[i-1]);
        }
        for (int j = height.length-2; j >= 0; j--) {
            right_max[j] = Math.max(right_max[j+1], height[j+1]);
        }
        int[] wateMax = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            int high_min = Math.min(left_max[i], right_max[i]);
            if (high_min - height[i] > 0) {
                wateMax[i] = high_min - height[i];
            }
        }
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            sum = sum + wateMax[i];
        }

//        int sum = 0;
//        for (int i = 0; i < height.length; i++) {
//            int high_min = Math.min(left_max[i], right_max[i]);
//            if (high_min - height[i] > 0) {
//                sum = sum + high_min - height[i];
//            }
//        }
        return sum;
    }
}
