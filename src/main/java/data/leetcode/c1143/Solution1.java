package data.leetcode.c1143;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-09
 */
public class Solution1 {
        public int longestCommonSubsequence(String text1, String text2) {
            //定义 dp[i][j] 为 text1的长度为i 和 text2的长度j 的最长公共子序列长度
            // if i < j
            // if(t1[i] == t2[j]) dp[i][j] = (dp[i][j-1] +1) && (t1[i] == t2[j-1])
            //dp[i][j] = dp[i-1][j]
            int m = text1.length();
            int n = text2.length();
            int[][] dp = new int[m+1][n+1];
            for(int i = 1; i <= m; i++) {
                for(int j = 1; j <= n; j++) {
                    if (text1.charAt(i-1) == text2.charAt(j-1)) {
                        dp[i][j] = 1 + dp[i-1][j-1];
                    } else {
                        dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                    }
                }
            }
            return dp[m][n];
        }
}
