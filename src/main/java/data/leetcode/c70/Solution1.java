package data.leetcode.c70;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-07
 */
public class Solution1 {
    public int climbStairs(int n) {
        int p = 0;
        int q = 0;
        int res = 1;
        for(int i = 1; i<= n; i++) {
            p = q;
            q = res;
            res = p + q;

        }
        return res;
    }
}
