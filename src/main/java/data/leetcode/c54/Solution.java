package data.leetcode.c54;

import java.util.ArrayList;
import java.util.List;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-26
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length; //col
        int n = matrix[0].length; //row
        int[][] direction = new int[][] {
                {0,1}, {1,0},
                {0,-1},{-1,0}
        };
//        int[] dr = {0, 1, 0, -1}; // 右、下、左、上四个方向
//        int[] dc = {1, 0, -1, 0};
        int currentDirection = 0;
        //访问标记
        boolean[][] visited = new boolean[m][n];
        List<Integer> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        //终止条件?
        int count = 0;
        while (count < m * n) {
            //标记访问
            res.add(matrix[i][j]);
            visited[i][j] = true;
            System.out.print("每次运动的方向:" + currentDirection);
            System.out.println(" i,j:" + i + " " + j);
            int di = i + direction[currentDirection][0];;
            int dj = j + direction[currentDirection][1];
            //方向判断
            if (di >= 0 && di < m && dj >= 0 && dj < n  && !visited[di][dj]) {
                //方向不变
                i = di;
                j = dj;
            } else {
                //方向变了
                currentDirection = (currentDirection+1) % 4;
                i +=  direction[currentDirection][0];
                j +=  direction[currentDirection][1];
            }
            count++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        new Solution().spiralOrder(matrix);
    }
}
