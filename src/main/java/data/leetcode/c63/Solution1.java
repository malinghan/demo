package data.leetcode.c63;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-08
 */
class Solution1 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] count = new int[m][n];
        if(obstacleGrid[0][0] == 1) {
            return 0;
        }
        if( m == 1 && n == 1) {
            return 1;
        }
        //首先求出第一行中的所有值，这里需要注意的是，如果dp[0][col]] = 0, 则之后所有大于col的值都应该是0
        //再求出第一列中的所有值，这里需要注意的是：如果dp[row][0] = 0, 则时候所有大于row的值都应该是0
        for(int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                while(i < m) {
                    obstacleGrid[i][0] = 1;
                    i++;
                }
                break;
            }
            count[i][0] = 1;
        }
        for(int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                while(j < n) {
                    obstacleGrid[0][j] = 1;
                    j++;
                }
                break;
            }
            count[0][j] = 1;
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    count[i][j] = 0;
                } else {
                    count[i][j] = count[i-1][j] + count[i][j-1];
                }
            }
        }
        return count[m-1][n-1];
    }
}
