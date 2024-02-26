package data.leetcode.c73;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-26
 * 时间复杂度： O( n * m)
 * 空间复杂度: O( n + m)
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];
        for(int  i = 0 ; i < matrix.length; i++) {
            for(int  j = 0 ; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for(int  i = 0 ; i < matrix.length; i++) {
            for(int  j = 0 ; j < matrix[0].length; j++) {
                if(rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}