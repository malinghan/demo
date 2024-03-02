package data.leetcode.c994;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-02
 * 多源广度优先搜索
 */
public class Solution {
    boolean[][] visited;
    public int orangesRotting(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid.length;
        int freshCount = 0;
        int count = 0;
        visited = new boolean[rowLen][colLen];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == 1) {
                    freshCount ++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int[][] direction = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
        while(!queue.isEmpty()) {
            System.out.println(freshCount);
            if (freshCount >= 0) {
                count++;
//                break;
            }
            int size = queue.size();
            for(int i = 0 ; i < size; i++) {
                int[] q = queue.poll();
                for(int j =0 ;  j < 4; j++) {
                    int newRow = q[0] + direction[j][0];
                    int newCol = q[1] + direction[j][1];
                    if (allow(grid, newRow, newCol) && !visited[newRow][newCol]
                            && grid[newRow][newCol] == 1) {
                        visited[newRow][newCol] = true;
                        queue.offer(new int[]{newRow,newCol});
                        freshCount--;
                    }
                }
            }
        }
        return freshCount == 0 ? count-1:-1;
    }

    boolean allow(int[][] grid,int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//
//        // 示例1
//        int[][] grid1 = {
//                {2, 1, 1},
//                {1, 1, 0},
//                {0, 1, 1}
//        };
//        int result1 = solution.orangesRotting(grid1);
//        System.out.println("示例1的结果: " + result1);
//
//        // 示例2
//        int[][] grid2 = {
//                {2, 1, 1},
//                {0, 1, 1},
//                {1, 0, 1}
//        };
//        int result2 = solution.orangesRotting(grid2);
//        System.out.println("示例2的结果: " + result2);
//
//        // 示例3
//        int[][] grid3 = {
//                {0, 2}
//        };
//        int result3 = solution.orangesRotting(grid3);
//        System.out.println("示例3的结果: " + result3);

        // 示例4
        int[][] grid4 = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };
        int result4 = solution.orangesRotting(grid4);
        System.out.println("示例4的结果: " + result4);
    }
}
