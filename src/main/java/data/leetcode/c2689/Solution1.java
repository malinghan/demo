package data.leetcode.c2689;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-16
 */
public class Solution1 {
    int path = 0;
    int maxPath = 0;
    boolean[][] visited;
    public int maxMoves(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        for(int i = 0 ; i < grid.length; i++) {
            dfs(grid, i, 0);
        }
        return maxPath;
    }
    void dfs(int[][] grid, int i, int j) {
        maxPath = Math.max(maxPath, path);
        if (!isAllow(grid, i ,j)) {
            return;
        }
        if(visited[i][j]) {
            return;
        }
        path++;
        int left = Math.max(i -1, 0);
        int right = Math.min(i+1, grid[0].length -1);
        for (int x = left; x <= right; x++) {
            if (grid[i][j] < grid[x][j + 1]) {
                dfs(grid, x, j + 1);
            }
        }
        visited[i][j] = true;
        path--;
    }

    boolean isAllow(int[][] grid, int i, int j) {
        return 0 <= i && i < grid.length && 0 <= j && j < grid[0].length;
    }
}