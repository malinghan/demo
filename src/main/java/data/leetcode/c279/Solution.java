package data.leetcode.c279;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-07
 */
public class Solution {
    public int numSquares(int n) {
        // 求n的平方根？
        // n = p^2 + q^2 + r^2
        // 设 f[i]表示最少需要多少个数来表示i
        // 定理：这些数必然落在 [1, 根号n]
        // 枚举 到 j, i -j^2 = m
        // f[i] = 1 + f[m] 一直到f[0] = 0
        // 1 <= n <= 104
        int[] f = new int[n+1];
        f[0] = 0;
        for(int i = 1; i<= n; i++) {
            int minN = Integer.MAX_VALUE;
            //寻找最大的j,使得 i - j*j最小
            for(int j = 1; j * j <= i; j++) {
                minN = Math.min(minN, f[i - j * j]);
            }
            f[i] = minN + 1; //多加一个j
        }
        return f[n];
    }
}