package data.leetcode.c2689;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-16
 */
class Solution {
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
        if(isAllow(grid, i-1, j+1) && grid[i][j] < grid[i-1][j+1]) {
            path++;
            visited[i][j] = true;
            dfs(grid, i-1, j+1);
            path--;
        }
        if(isAllow(grid, i, j+1) && grid[i][j] < grid[i][j+1]) {
            path++;
            visited[i][j] = true;
            dfs(grid, i, j+1);
            path--;
        }
        if(isAllow(grid, i+1, j+1) && grid[i][j] < grid[i+1][j+1]) {
            path++;
            visited[i][j] = true;
            dfs(grid, i+1, j+1);
            path--;
        }
    }

    boolean isAllow(int[][] grid, int i, int j) {
        return 0 <= i && i < grid.length && 0 <= j && j < grid[0].length;
    }
}
