package data.leetcode.c2689;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-16
 */
public class Solution4 {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] vis = new int[m];
        Arrays.fill(vis, -1);
        List<Integer> q = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            q.add(i);
        }
        for (int j = 0; j < n - 1; j++) {
            List<Integer> nxt = new ArrayList<>();
            for (int i : q) {
                for (int k = Math.max(i - 1, 0); k < Math.min(i + 2, m); k++) {
                    if (vis[k] != j && grid[k][j + 1] > grid[i][j]) {
                        vis[k] = j; // 第 k 行目前最右访问到了 j
                        nxt.add(k);
                    }
                }
            }
            if (nxt.isEmpty()) { // 无法再往右走了
                return j;
            }
            q = nxt;
        }
        return n - 1;
    }
}