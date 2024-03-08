package data.leetcode.c50;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-07
 */
class Solution {
    public double myPow(double x, int n) {
        return n >= 0 ? myPowLong(x , n) : 1.0 / myPowLong(x, -n);
    }

    public double myPowLong(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double y = myPowLong(x, n/2);
        if (n % 2 == 0) {
            return y * y;
        } else {
            return x * y * y;
        }
    }
}