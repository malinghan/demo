package data.leetcode.c121;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-07
 */
public class Solution1 {
     public int maxProfit(int[] prices) {
        int maxProfit = 0;
         // profit[i] 表示第i天卖出的最大收益
         // min[i] 表示前 i天的最小值
         // profit[i] = prices - min[i];
         int[] min = new int[prices.length];
           min[0] = prices[0];
         for (int i  = 1; i < prices.length; i++) {
             min[i] = Math.min(prices[i], min[i-1]);
         }
         for (int i  = 1; i < prices.length; i++) {
             maxProfit = Math.max((prices[i] - min[i]), maxProfit);
         }
        return maxProfit;
     }
}
