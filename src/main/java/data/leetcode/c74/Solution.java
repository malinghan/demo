package data.leetcode.c74;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-04
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m * n -1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            int x = matrix[mid / n][mid % n];
            if (x == target) {
                return true;
            } else if (x < target) {
                start = mid +1;
            } else {
                end = mid -1;
            }
        }
        return false;
    }
}