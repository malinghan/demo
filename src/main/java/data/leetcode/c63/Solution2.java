package data.leetcode.c63;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-08
 */
public class Solution2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] count = new int[n];
        if(obstacleGrid[0][0] == 1) {
            return 0;
        } else {
            count[0] = 1;
        }
        if( m == 1 && n == 1) {
            return 1;
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    count[j] = 0;
                    continue;
                }
                if ( j >= 1 && obstacleGrid[i][j-1] == 0) {
                    count[j] = count[j] + count[j-1];
                }
            }
        }
        return count[n-1];
    }
}
