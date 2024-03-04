package data.leetcode.c84;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-04
 *
 */
public class Solution3 {
    public int largestRectangleArea(int[] heights) {
        int s = -1;
        Deque<Integer> stack = new LinkedList<>();
        int n = heights.length;
        //以i的高度的左边界下标
        int[] left = new int[n];
        //以i的高度的右边界下标
        int[] right = new int[n];
        left[0] = -1;
        right[n-1] = n;
        for (int i = 1; i < n; i++) {
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            left[i] = stack.isEmpty()? -1: stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = n-2; i >= 0; i--) {
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                stack.pop();
            }
            right[i] = stack.isEmpty()? n: stack.peek();
            stack.push(i);
        }

        for(int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            s = Math.max(s , width * heights[i]);
        }
        return s;
    }
}
