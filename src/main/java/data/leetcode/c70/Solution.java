package data.leetcode.c70;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-07
 */
public class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] count = new int[n+1];
        count[0] = 0;
        count[1] = 1;
        count[2] = 2;
        for(int i = 3; i<= n; i++) {
            count[i] = count[i-1] +count[i-2];
        }
        return count[n];
    }
}
