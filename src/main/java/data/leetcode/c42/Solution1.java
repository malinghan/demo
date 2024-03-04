package data.leetcode.c42;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-04
 */
public class Solution1 {
        public int trap(int[] height) {
            int n = height.length;
            Deque<Integer> stack = new LinkedList<>();
            int current  = 0;
            int sum = 0;
            while(current < height.length) {
                while(!stack.isEmpty() && height[current] > height[stack.peek()]) {
                    int node = stack.pop();
                    if (stack.isEmpty()) {
                        break;
                    }
                    int width = current - stack.peek() - 1;
                    int min = Math.min(height[stack.peek()], height[current]);
                    sum += width * (min - height[node]);
                }
                stack.push(current);
                current++;
            }
            return sum;
        }
}
