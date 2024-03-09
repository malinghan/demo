package data.leetcode.c1143;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-08
 */
public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        //定义 dp[i][j] 为 包含 text1.charAt(i)和包含 text1.charAt(j)的最长公共子序列长度
        // if i < j
        // if(t1[i] == t2[j]) dp[i][j] = (dp[i][j-1] +1) && (t1[i] == t2[j-1])
        //dp[i][j] = dp[i-1][j]
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (i  == 0 && j == 0) {
                    if (text1.charAt(i) == text2.charAt(j)) {
                        dp[i][j] = 1;
                    }
                } else if (i > 0 && j > 0) {
                    if (text1.charAt(i) == text2.charAt(j)) {
                        dp[i][j] = 1 + dp[i-1][j-1];
                    } else {
                        dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                    }
                } else if(j > 0) {
                    if (text1.charAt(i) == text2.charAt(j)) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i][j-1];
                    }
                } else if (i > 0){
                    if (text1.charAt(i) == text2.charAt(j)) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        return dp[m-1][n-1];
    }

}