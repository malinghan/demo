package data.leetcode.c51;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-03
 * 技巧：如果标识在同一条右斜线？ i -j
 * 如何标识在同一条左斜线? i + j
 */
public class Solution {
    List<List<String>> res;
    List<String> list;
    List<Integer> visited;
    Set<Integer> left; // i-j
    Set<Integer> right; // i+j
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        visited = new ArrayList<>();
        left = new HashSet<>();
        right = new HashSet<>();
        backtrack(n, 0);
        return res;
    }
    //按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
    void backtrack(int n, int level) {
        if (list.size() == n) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < n; i++) {
            if(visited.contains(i)) {
                continue;
            }
            //剪;在同一行或同一列
            //剪;或同一斜线上
            if(left.contains(level-i)) {
                continue;
            }
            if(right.contains(level+i)) {
                continue;
            }
            visited.add(i);
            left.add(level - i);
            right.add(level + i);
            list.add(buildString(i, n));
            backtrack(n, level+1);
            list.remove(list.size()-1);
            visited.remove(visited.size() -1);
            left.remove(level - i);
            right.remove(level + i);
        }
    }

    String buildString(int index, int n) {
        StringBuilder sb = new StringBuilder("");
        for (int j = 0; j < n; j++) {
            if (j == index) {
                sb.append("Q");
            } else {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        List<List<String>> res = new Solution().solveNQueens(4);
        for (List<String> re : res) {
            System.out.println(re);
        }
    }
}
