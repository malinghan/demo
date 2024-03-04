package data.leetcode.c35;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-04
 */
public class Solution1 {
        public int searchInsert(int[] nums, int target) {
            int n = nums.length;
            return searchInsert(nums, target, 0 , n-1);
        }

        int searchInsert(int[] nums, int target, int l, int r) {
            if (l > r) {
                return l;
            }
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                return searchInsert(nums, target, mid +1, r);
            } else {
                return searchInsert(nums, target, l, mid -1);
            }
        }
}