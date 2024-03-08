package data.leetcode.c63;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-08
 */
class Solution {
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
        for(int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            count[i][0] = 1;
        }
        for(int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            }
            count[0][j] = 1;
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    count[i][j] = count[i-1][j] + count[i][j-1];
                }
            }
        }
        return count[m-1][n-1];
    }
}
