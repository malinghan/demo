package data.leetcode.c33;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-04
 */
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n-1;
        //这样区间不会重合
        while(l < r) {
            //偶数偏左边界
            int mid = l + (r-l)/2;
            if (nums[mid] > nums[n-1]) {
                l = mid +1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }

    //思考测试用例
    //[1]
    //[1,2]
    //[2,1]
}