package data.leetcode.c5;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-08
 */
public class Solution3 {
    public String longestPalindrome(String s) {
        int  n = s.length();
        if(s.length() < 2) {
            return s;
        }
        //从i到j是否是回文串 满足 dp[i][j] = dp[i+1][j-1] && s.charAt[i] == s.charAt[j]''
        boolean[][] dp = new boolean[n][n];
        //初始化
        for(int i = 0;  i < n; i++) {
            //正对角线都是回文
            dp[i][i] = true;
        }
        int begain = 0;
        int end = 0;
        //从长度开始计算
        //        dp[0][0] = 1  dp[1][1] = 1
        //len = 2 i = 0  j = 1 dp[0][1] = dp[1][0] &&
        //
        for(int len = 2;  len <= n; len ++) {
            for(int i = 0; i < n; i++) {
                int j = len + i - 1;
                if (j >= n) {
                    break;
                }
                if (j - i < 2 ) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j);
                }

                if (dp[i][j]) {
                    begain = i;
                    end = j;
                }
            }
        }
        return s.substring(begain, end+1);
    }
}