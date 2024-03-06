package data.leetcode.c34;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-04
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n-1;
        int[] res = new int[]{-1,-1};
        while(l <= r) {
            int mid = (r- l) /2 +l;
            if (nums[mid] == target) {
                int i = mid;
                while(i > 0 && nums[i] == nums[i-1]) {
                    i--;
                }
                res[0] = i;
                int j = mid;
                while(j < n -1 && nums[j] == nums[j+1]) {
                    j++;
                }
                res[1] = j;
                return res;
            } else if (nums[mid] < target) {
                l = mid+1;
            } else {
                r = mid -1;
            }
        }
        return res;
    }
}