package data.leetcode.c48;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-26
 */
public class Solution {
    public void rotate(int[][] matrix) {
      int  n = matrix[0].length;
        int[][] newMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newMatrix[j][n-i-1] = matrix[i][j];
            }
        }
      // newMatrix[j][n-i-1] = matrix[i][j]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = newMatrix[i][j];
            }
        }
        System.out.println("aaa");
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        new Solution().rotate(matrix);
    }
}
