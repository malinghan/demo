package data.leetcode.c11;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2023-12-02
 */
public class Solution {
    /**
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     *
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 返回容器可以储存的最大水量。
     *
     * 动态规划思考模板:
     * 1. 动态方程
     * 2. 起步条件
     * 3. 终止条件
     *
     * 动态规划
     *
     * 双指针移动遍历计算所有条件
     *
     * 问题: 双指针如何保证不漏？
     * 怎么证明其为充分必要解?
     *
     * 在每个状态下，无论长板或短板向中间收窄一格，都会导致水槽 底边宽度 −1 变短：
     * 若向内 移动短板 ，水槽的短板 min(h[i],h[j]) 可能变大，因此下个水槽的面积 可能增大 。
     * 若向内 移动长板 ，水槽的短板 min(h[i],h[j])不变或变小，因此下个水槽的面积 一定变小 。
     *
     * 我的理解: 水槽的面积 为宽度 * 高度， 而高度由左右两边的短板决定。
     * 初始化时，宽度是最大化的，之后逐渐变小，所以当务之急就是找到高的板子，计算面积。
     */
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int maxArea = 0;
        while(l < r) {
            int currArea = Math.min(height[l], height[r]) * (r - l);
            maxArea  = Math.max(currArea, maxArea);
            if (height[l] < height[r] ) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}
