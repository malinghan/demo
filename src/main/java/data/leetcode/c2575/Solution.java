package data.leetcode.c2575;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-07
 */
class Solution {
    public int[] divisibilityArray(String word, int m) {
        //判断一个数是否能被整除   x mod m == 0
        //计算机语言如何定义mod ===> %
        //如何累加 x* 10+y
        int n = word.length();
        int[] div = new int[n];
        long x = 0;
        for(int i = 0 ; i < n; i++) {
            //  x = x * 10 + Integer.valueOf(String.valueOf(word.charAt(i)));
            // (a×10+b) mod m=(a mod m ×10 +b) mod m
            x = (x * 10 + (word.charAt(i) - '0')) % m;
            System.out.println(x);
            if (x % m == 0) {
                div[i] = 1;
            } else {
                div[i] = 0;
            }
        }
        return div;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().divisibilityArray("1010", 10));
    }
}