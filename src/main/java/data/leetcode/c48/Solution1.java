package data.leetcode.c48;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-26
 */
public class Solution1 {
    public void rotate(int[][] matrix) {
        int  n = matrix[0].length;
        //水平翻转
        // for (int i = 0; i < n/2; i++) {
        //     for (int j = 0; j < n; j++) {
        //         int temp = matrix[i][j];
        //         matrix[i][j] = matrix[n-i-1][j]; // [0,0] -> [0,2]
        //         matrix[n-i-1][j] = temp;
        //     }
        // }
        //左对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i]; // [0,0] [1,0]
                matrix[j][i] = temp;
            }
        }
        //垂直翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1]; // [0,0] -> [0,2]
                matrix[i][n-j-1] = temp;
            }
        }
        System.out.println("aaa");
    }
}