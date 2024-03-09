package data.leetcode.c72;

class Solution {
    public int minDistance(String word1, String word2) {
       // int[][] dp 表示 w1前i个数，变成w2前j个数，所需要的最小操作步数
       // 动态方程: 
       //1. if   w1[i]==w2[j] dp[i][j] = dp[i-1][j-1]
       //2. else dp[i][j] = MIN(dp[i-1][j-1],dp[i-1][j],dp[i][j-1])+1
       // 初始化:
       // dp[0][j] = j  dp[i][0] = i 操作全是删除、新增
       int m = word1.length();
       int n = word2.length();
       int[][] dp = new int[m+1][n+1];
       for(int i = 0; i <= m; i++) {
           dp[i][0] = i;
       }
       for(int j = 0 ; j <= n; j ++) {
           dp[0][j] = j;
       }

       for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j ++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
                }
            }
       }
       return dp[m][n];
    }
}