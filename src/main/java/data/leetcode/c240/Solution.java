package data.leetcode.c240;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-26
 * 每一行进行二分查找
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
           int index = binarySearch(matrix[i], target);
           if (index >= 0) {
               System.out.println("["+i+" "+index+"]");
               return true;
           }
        }
        return false;
    }

    //默写二分查找算法
    static int binarySearch(int[] arr, int target) {
        int n = arr.length;
        int l = 0;
        int r = n-1;
        while(l <= r) {
            int mid = l + ( r - l) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                l++;
            } else {
                r--;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6};
//        System.out.println(binarySearch(arr,8));
        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        new Solution().searchMatrix(matrix, 8);
    }
}
