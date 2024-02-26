package data.leetcode.c73;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-26
 * 使用第一行第一列充当标记位
 */
public class Solution1 {
    public void setZeroes(int[][] matrix) {
        boolean flagCol0 = false, flagRow0 = false;
        for (int  i = 0 ; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
        }
        for(int  j = 0 ; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                flagRow0 = true;
            }
        }

        for (int  i = 1 ; i < matrix.length; i++) {
            for(int  j = 1 ; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int  i = 1 ; i < matrix.length; i++) {
            for(int  j = 1 ; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (flagCol0) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        if (flagRow0) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
