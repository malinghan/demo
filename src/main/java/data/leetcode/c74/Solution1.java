package data.leetcode.c74;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-04

 */
public class Solution1 {
        public boolean searchMatrix(int[][] matrix, int target) {
            int  rowIndex = binarySearchRow(matrix, target);
            if (rowIndex < 0) {
                return false;
            }
            return binarySearch(matrix[rowIndex], target);
        }

    public int binarySearchRow(int[][] matrix, int target) {
            int low = -1, high = matrix.length -1;
            while(low < high) {
                int mid = (high - low)/2 + low;
                if (matrix[mid][0] <= target) {
                    low = mid;
                } else {
                    high = mid -1;
                }
            }
            return low;
        }

    public  boolean binarySearch(int[] row, int target) {
            int low = 0, high = row.length -1;
            while(low <= high) {
                int mid = (high - low)/2 + low;
                if (row[mid] == target) {
                    return true;
                } else if (row[mid] > target) {
                    high = mid -1;
                } else {
                    low = mid +1;
                }
            }
            return false;
        }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };
        System.out.println(new Solution().searchMatrix(matrix, 13));
    }
}
