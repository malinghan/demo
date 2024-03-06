package data.leetcode.c34;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-04
 */
class Solution1 {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n-1;
        int[] res = new int[]{-1,-1};
        res[0] = binarySearchLeft(nums, target);
        res[1] = binarySearchRight(nums, target);
        return res;
    }

    public int binarySearchLeft(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n-1;
        int left = -1;
        while(l <= r) {
            int mid = (r- l) /2 +l;
            if (nums[mid] == target) {
                r = mid -1;
                left = mid;
            } else if (nums[mid] < target) {
                l = mid +1;
            } else {
                r = mid -1;
            }
        }
        return left;
    }

    public int binarySearchRight(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n-1;
        int right = -1;
        while(l <= r) {
            int mid = (r- l) /2 +l;
            if(nums[mid] == target) {
                l = mid +1;
                right = mid;
            } else if (nums[mid] < target) {
                l = mid+1;
            } else {
                r = mid -1;
            }
        }
        return right;
    }
}