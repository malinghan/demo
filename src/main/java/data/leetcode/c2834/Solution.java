package data.leetcode.c2834;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-08
 */
class Solution {
    public int minimumPossibleSum(int n, int target) {
        // 有 i 就没有 target - i, 说明：
        // 最大可以添加 target/2, 之后从 target, target+1,target+2开始添加
        // 设 m = target /2
        // 若 n <= m  minSum = ((1 + n) * n )/2
        //若 n > m   minSum = ((1 + m) * m)/2 +   ((target + target + (n - m) -1 ) * (n - m))/2
        final int MOD = (int) 1e9 + 7;
        int m = target / 2;
        if (n <= m) {
            return (int) (((long)(1 + n) * n )/2 % MOD);
        } else {
            return (int)  (
                    ((long) (1 + m) * m/2 +
                            ((long) target + target + (n - m) -1 ) * (n - m)/2)% MOD);
        }
    }
}