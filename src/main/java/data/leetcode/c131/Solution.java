package data.leetcode.c131;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-03
 * 给定一个字符串s, f[i][j] 表示 i到j这段子串是否是回文串，
 * 设 s的长度为 n, 则f[i][j] 为 n*n的矩阵 f[i][j] => boolean[n][n]
 * 求解f[i][j] 使用动态规划满足
 * 1. 如果 i >= j  f[i][j] = true;
 * 2. 否则 f[i][j] = f[i+1][j-1] && s[i] == s[j];
 *
 * 如何通过f[i][j], 划分s的回文串呢?
 * 回溯思维：往后递归
 *    剪枝条件: f[i][j] == false跳过
 */
public class Solution {
    List<List<String>> res;
    List<String> list;
    boolean[][] f;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        f = getF(s);
        backtrack(s, 0);
        return res;
    }

    void backtrack(String s, int index) {
         if (index == s.length()) {
             res.add(new ArrayList<>(list));
             return;
         }
        for (int j = index; j < s.length(); j++) {
            if(!f[index][j]) {
                continue;
            }
            list.add(s.substring(index, j+1));
            backtrack(s, j+1);
            list.remove(list.size() -1);
        }
    }

    public static void main(String[] args) {
        boolean[][] f = new Solution().getF("aab");
        for (int i = 0; i < f.length; i++) {
            System.out.println(Arrays.toString(f[i]));
        }
        List<List<String>> res = new Solution().partition("aab");
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    boolean[][] getF(String s) {
        int n = s.length();
        boolean[][] f = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j] = true;
            }
        }
        // n = 3 i=2 j=2
        // i = 2 j = 3  直接返回
        // i = 1 j = 2  满足  f[1][2] = false && f[2][1] == false;
        // i = 1 j = 3  直接返回
        // i = 0 j = 1 满足 f[0][1] = true
        // i = 0 j = 2 满足 f[0][2] = false;
        //[0,2][1,2] 整个上三角赋值完毕(i < j)
        for (int i = n-1; i >= 0; i--) {
            for (int j = i+1; j  < n; j++) {
                f[i][j] =  (s.charAt(i) == s.charAt(j)) && f[i+1][j-1];
                //f[n-2][n-1] = true && f[n-1][n-2];
                // i = n-2
                // f[n-2][n]
            }
        }
        return f;
    }
}
