package data.leetcode.c4;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-05
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        //设定m是短的数组
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
            //   int[] temp = nums1;
            //   nums1 = nums2;
            //   nums2 = temp;
        }
        //计算中位数的位置，分奇数和偶数讨论
        //如果是奇数 (m+n+1)/2 如果是偶数 (m+n)/2 或者是 (m+n+1)/2 统一为 (m+n+1)/2
        int totalLeft = (m+n+1)/2;
        //开始划分数组??
        int l = 0;
        int r = m;
        //划分位置？满足 i + j = (m+n+1)/2
        while( l < r) {
            int i = l + (r-l + 1)/2;
            int j = totalLeft - i;
            if (nums1[i-1] > nums2[j]) {
                //下一轮的搜索的范围是 [l, i-1]
                r = i - 1;
            } else {
                //下一轮的搜索的范围是 [i, r]
                l = i;
            }
        }
        int i = l;
        int j = totalLeft - i;
        int nums1Start = (i == 0 ? Integer.MIN_VALUE : nums1[i-1]);
        int nums1End = (i == m ? Integer.MAX_VALUE :nums1[i]);
        int nums2Start = (j == 0 ? Integer.MIN_VALUE : nums2[j-1]);
        int nums2End = (j == n ? Integer.MAX_VALUE : nums2[j]);
        int leftMaxVale = Math.max(nums1Start, nums2Start);
        int rightMinValue = Math.min(nums1End, nums2End);
        if ((m+n) % 2 == 1) {
            return Math.max(nums1Start, nums2Start);
        } else {
            return (double) ((Math.max(nums1Start, nums2Start) + Math.min(nums1End, nums2End)))/2;
        }
    }
    // 1,2,3,4,5,6
}