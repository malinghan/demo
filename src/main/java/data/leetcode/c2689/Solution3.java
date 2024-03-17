package data.leetcode.c2689;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-16
 */
public class Solution3 {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //
        int[] vis = new int[m];
        Arrays.fill(vis, -1);
        Queue<Integer> queue = new LinkedList<>();
        //一开始把所有 (i,0) 都加入一个列表
        for (int i = 0; i < m; i++) {
            queue.offer(i);
        }
        //每一轮循环，遍历列表中的坐标，把右边这一列的能到达的格子坐标加入一个新列表
        int j = 0;
        while(!queue.isEmpty() && j < grid[0].length-1) {
            int size = queue.size();
            for (int x = 0; x < size; x++) {
                int i = queue.poll();
                for (int k = Math.max(i - 1, 0); k < Math.min(i + 2, m); k++) {
                    if (vis[k] != j && grid[k][j + 1] > grid[i][j]) {
                        vis[k] = j; // 第 k 行目前最右访问到了 j
                        queue.add(k);
                    }
                }
            }
            if(queue.isEmpty()) {
                return j;
            }
            j++;
        }
        return n-1;
    }
}
