package data.leetcode.c994;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-02
 * 多源广度优先搜索
 */
public class Solution1 {
    public int orangesRotting(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int freshCount = 0;
        int count = 0;
        int  rottedCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == 1) {
                    freshCount ++;
                }
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                    rottedCount++;
                }
            }
        }
        System.out.println("freshCount" + freshCount);
        System.out.println("rottedCount" + rottedCount);
        if (freshCount == 0 && rottedCount == 0) {
            return -1;
        }
        if (freshCount == 0 && rottedCount != 0) {
            return 0;
        }
        int[][] direction = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
        while(!queue.isEmpty() && freshCount > 0) {
            System.out.println(freshCount);
            int size = queue.size();
            for(int i = 0 ; i < size; i++) {
                int[] q = queue.poll();
                for(int j =0 ;  j < 4; j++) {
                    int newRow = q[0] + direction[j][0];
                    int newCol = q[1] + direction[j][1];
                    if (allow(grid, newRow, newCol)
                            && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        queue.offer(new int[]{newRow,newCol});
                        freshCount--;
                    }
                }
            }
            count++;
        }
        return freshCount == 0 ? count:-1;
    }

    boolean allow(int[][] grid,int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
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
        // 示例3
        int[][] grid3 = {
                {0, 2}
        };
        int result3 = solution.orangesRotting(grid3);
        System.out.println("示例3的结果: " + result3);

        // 示例4
//        int[][] grid4 = {
//                {2,1,1},
//                {1,1,0},
//                {0,1,1}
//        };
//        int result4 = solution.orangesRotting(grid4);
//        System.out.println("示例4的结果: " + result4);
    }
}
