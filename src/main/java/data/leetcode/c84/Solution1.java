package data.leetcode.c84;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-04
 * 基本思路:
 * 单调栈， 有哨兵模式
 */
class Solution1 {
        public int largestRectangleArea(int[] heights) {
            int s = -1;
            Deque<int[]> stack = new LinkedList<>();
            int n = heights.length;
            //哨兵
             stack.push(new int[]{-1,0});
            for (int i = 0; i < n; i++) {
                while(!stack.isEmpty() && heights[i] < stack.peek()[1]) {
                    int[] node = stack.pop();
                    int width = 0;
//                    while(!stack.isEmpty() && heights[i] == node[1]) {
//                        stack.pop();
//                    }
//                    if (stack.isEmpty()) {
//                        width = i;
//                    } else {
                        width = i - stack.peek()[0] -1;
//                    }
                    int newS = width * node[1];
                    s = Math.max(s , newS);
                }
                stack.push(new int[] {i, heights[i]});
            }

//            while(!stack.isEmpty()) {
            while(stack.peek()[0] != -1) {
                int[] node = stack.pop();
                int width = 0;
//                while(!stack.isEmpty() && stack.peek()[1] == node[1]) {
//                    stack.pop();
//                }
//                if (stack.isEmpty()) {
//                    width = n;
//                } else {
                    width = n - stack.peek()[0] -1;
//                }
                int newS = width * node[1];
                s = Math.max(s , newS);
            }

            return s;
        }

    public static void main(String[] args) {
        System.out.println(
                new Solution1().largestRectangleArea(new int[]{2,1,5,6,2,3})
        );
    }
}