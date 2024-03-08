package data.leetcode.c62;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-08
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] count = new int[m][n];
        if (m == 1 || n == 1) {
            return 1;
        }
        for(int i = 0; i < m; i++) {
            count[i][n-1] = 1;
        }

        for(int j = 0; j < n; j++) {
            count[m-1][j] = 1;
        }
        for(int i = m-2; i >= 0; i--) {
            for(int j = n-2; j >= 0; j--) {
                count[i][j] = count[i+1][j] + count[i][j+1];
            }
        }
        return count[0][0];
    }
}