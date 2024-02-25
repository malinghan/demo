package data.leetcode.c42;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2023-12-06
 * 双指针: 正确性证明
 *  证明: 如果height_right > leftMax, 且存在 rightMax, 则一定有 rightMax >= 如果height_right
 *  则有  Math.min(leftMax, rightMax) =  Math.min(leftMax, 如果height_right) = leftMax
 *  因此 water[i]的高度会被左侧固定
 */
public class Solution2 {
    public int trap(int[] height) {
        //双指针其实是动态规划的一种优化算法
        //动态规划的思路: 当前雨水的容量 water = Math.min(leftMax, rightMax);
        //但其实可以更简化，如果height_right > leftMax 那么 water[i]的高度就会固定
        // 证明: 如果height_right > leftMax, 且存在 rightMax, 则一定有 rightMax >= 如果height_right
        //则有  Math.min(leftMax, rightMax) =  Math.min(leftMax, 如果height_right) = leftMax
        //因此 water[i]的高度会被左侧固定
        int i = 0, j = height.length -1;
        int leftMax = 0;
        int rightMax  = 0;
        int sum = 0;
        while(i < j) {
            leftMax = Math.max(height[i], leftMax);
            rightMax = Math.max(height[j], rightMax);
            if (height[i] < height[j]) {
                sum = sum + leftMax - height[i];
                i++;
            } else {
                sum = sum + rightMax - height[j];
                j--;
            }
        }
        return sum;
    }
}
