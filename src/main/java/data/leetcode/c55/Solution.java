package data.leetcode.c55;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-07
 */
class Solution {
    public boolean canJump(int[] nums) {
        //先用最大长度跳跃,如果不行，依次递减
        //需要记录路径，用于返回
        int n = nums.length;
        int maxJump = 0;
        //设 int[] maxjump 表示以i为起点，能跳跃的最远距离
        for(int i = 0; i < n; i++) {
            if (i <= maxJump) {
                maxJump = i + nums[i];
                if(maxJump >= n-1) {
                    return true;
                }
            }
        }
        return false;
    }
}
// 2 3 1 1 4
//  i  maxJump
//  0  2 < 4
//  1  4 == 4

// 3 2 1 0 4
//  i  maxJump
//  0  3 < 4
//  1  3 < 4
//  2 3 < 4
//  3  3 < 4
//  4  3 > 4 但是 4> 3不可达