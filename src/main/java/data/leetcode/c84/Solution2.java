package data.leetcode.c84;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-04
 * 基本思路:
 *  要计算最大面积，要先求出以i为高度的最大面积，且i满足：
 *  左右的高度都比他小  left < height[i] >  right
 * 实现：
 * 给定一个单调栈，出栈入栈规则：
 * - 单调递增入栈 if(stack.peek() >= height[i])  stack.push(height[i])
 * - 寻找比栈顶小的元素，然后循环弹出  if(stack.peek() < height[i]) {
 *     while(stack.peek() < height[i]) { stack.pop()}
 * }
 * 计算时机：
 * 每次弹出时计算面积
 * weight = j - stack.peek();
 * weight * height[j]
 *
 * 无哨兵模式: 只保存下标
 */
class Solution2 {
        public int largestRectangleArea(int[] heights) {
            int s = -1;
            Deque<Integer> stack = new LinkedList<>();
            int n = heights.length;
            for (int i = 0; i < n; i++) {
                while(!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                    Integer node = stack.pop();
                    int width = 0;
                    if (stack.isEmpty()) {
                        width = i;
                    } else {
                        width = i - stack.peek() -1;
                    }
                    int newS = width * heights[node];
                    s = Math.max(s , newS);
                }
                stack.push(i);
            }

            while(!stack.isEmpty()) {
                Integer node = stack.pop();
                int width = 0;
                if (stack.isEmpty()) {
                    width = n;
                } else {
                    width = n - stack.peek() -1;
                }
                int newS = width * heights[node];
                s = Math.max(s , newS);
            }

            return s;
        }

    public static void main(String[] args) {
        System.out.println(
                new Solution2().largestRectangleArea(new int[]{2,1,5,6,2,3})
        );
    }
}