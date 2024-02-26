package data.leetcode.c240;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-26
 */
public class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length-1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                System.out.println(i+ " "+j);
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6};
        //        System.out.println(binarySearch(arr,8));
        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        new Solution1().searchMatrix(matrix, 8);
    }
}
