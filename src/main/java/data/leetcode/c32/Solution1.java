package data.leetcode.c32;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-07
 */
public class Solution1 {
    public int longestValidParentheses(String s) {
        //给定f[i] 为以i的结束点的最长有效括号
        //if s.charAt[i] = '(' 直接为0，不是有效括号
        // f[0] = 0;
        // if s.charAt[i] = ')' 分类讨论
        // s.charAt[i] = '('  直接有动态方程 f[i] = f[i-2] + 2;
        // 如果 s.charAt[i] = ')' 可能是 （()())这种类型，也有可能是(())
        // 假设 leftIndex = i - f[i-1] 不管那种都必须有 leftIndex -1 >= 0
        //分类讨论
        // leftIndex -2 >= 0 f[i] = f[i-1] + f[i - leftIndex -2] + 2;
        //leftIndex - 2 < 0  f[i]  = f[i-1] + 2; //前面没东西了
        int n  = s.length();
        int[] f = new int[n];
        int maxLen = 0;
        for(int i = 1; i < n; i++) {
            if (s.charAt(i) == '(') {
                f[i] = 0;
            } else {
                if (s.charAt(i-1) == '(') {
                    if(i == 1) {
                        f[i] = 2;
                    } else {
                        f[i] = f[i - 2] + 2;
                    }
                } else {
                    // ..((...))
                    int leftIndex = i - f[i-1];
                    if (leftIndex -1 >= 0 && s.charAt(leftIndex - 1) == '(') {
                        if (leftIndex >= 2) {
                            f[i] = f[i - 1] + f[leftIndex-2] + 2;
                        } else {
                            f[i] =  f[i - 1] + 2;
                        }
                    }
                }
            }
            maxLen = Math.max(f[i], maxLen);
        }
        return maxLen;
    }
}
