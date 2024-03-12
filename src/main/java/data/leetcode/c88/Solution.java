package data.leetcode.c88;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-12
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int tail = m + n -1;
        while (i >= 0 || j >= 0) {
            //考虑nums1为空的情况
            int curr = 0;
            if (i == -1) {
                curr = nums2[j];
                j--;
            } else if (j == -1) {
                curr = nums1[i];
                i--;
            } else if (nums1[i] > nums2[j]) {
                curr = nums1[i];
                i--;
            } else {
                curr = nums2[j];
                j--;
            }
            nums1[tail] = curr;
            tail--;
        }
    }
}