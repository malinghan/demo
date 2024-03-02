package data.leetcode.c200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-02
 */
public  class Solution {
    public int numIslands(char[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int numsOfIslands = 0;
        for(int i = 0 ; i < rowLen ; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == '1') {
                    numsOfIslands++;
                    bfs(grid, i, j, rowLen, colLen);
                }
            }
        }
        return numsOfIslands;
    }

    private void bfs(char[][] grid, int r, int c, int rowLen, int colLen) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(r * colLen + c);
        grid[r][c] = '0';
        while (!queue.isEmpty()) {
            int id = queue.poll();
            int row = id / colLen;
            int col = id % colLen;
            if (allow(grid, row -1, col) && grid[row -1][col] == '1') {
                queue.offer((row -1) * colLen + col);
                grid[row-1][col] = '0';
            }
            if (allow(grid, row +1, col) && grid[row +1][col] == '1') {
                queue.offer((row +1) * colLen + col);
                grid[row+1][col] = '0';
            }
            if (allow(grid, row, col-1) && grid[row][col-1] == '1') {
                queue.offer((row) * colLen + col-1);
                grid[row][col-1] = '0';
            }
            if (allow(grid, row, col+1) && grid[row][col+1] == '1') {
                queue.offer((row) * colLen + col+1);
                grid[row][col+1] = '0';
            }
        }
    }

    boolean allow(char[][] grid, int r, int c) {
        return 0 <= r  && r < grid.length && 0 <= c && c < grid[0].length;
    }
}
