package data.leetcode.c121;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-07
 * 求最小值即可
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        for(int i = 0 ; i < prices.length; i++) {
            if (!stack.isEmpty() && prices[stack.peek()] < prices[i]) {
                int start = prices[stack.peek()];
                int end = prices[i];
                maxProfit = Math.max(maxProfit, end - start);
            } else{
                stack.push(i);
            }
        }
        return maxProfit;
    }
}
