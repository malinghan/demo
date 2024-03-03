package data.leetcode.c79;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-03
 */
class Solution {
    boolean exist;
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        int rowLen = board.length;
        int colLen = board[0].length;
        visited = new boolean[rowLen][colLen];
        exist = false;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (board[i][j] == word.charAt(0)) {
                    backtrack(board, i, j, word, 0);
                }
            }
        }
        return exist;
    }

    void backtrack(char[][] board, int r, int c, String word, int index) {
        if (word.charAt(index) != board[r][c]) {
            exist = false;
            return;
        }
        //避免 aa出现
        if (index == word.length() -1) {
            exist = true;
            return;
        }
        visited[r][c] = true;
        int[][] direction = new int[][] {
                {1,0},{-1,0},{0,1},{0,-1}
        };
        for(int i =0; i < 4; i++) {
            int newR = r + direction[i][0];
            int newC = c + direction[i][1];
            if (!isAllow(board, newR, newC)) {
                continue;
            }
            if (visited[newR][newC]) {
                continue;
            }
            if(board[newR][newC] != word.charAt(index+1)) {
                continue;
            }
            backtrack(board, newR, newC, word, index + 1);
        }
        visited[r][c] = false;
    }

    boolean isAllow(char[][] board, int r, int c) {
        return 0 <= r && r < board.length  && 0 <= c && c < board[0].length;
    }

//    public static void main(String[] args) {
//        char[][] board = new char[][] {
//                {'A','B','C','E'},
//                {'S','F','C','S'},
//                {'A','D','E','E'}
//        };
//        new MedianFinder().exist(board, "ABCCED");
//    }

    public static void main(String[] args) {
        char[][] board = new char[][] {
                {'A','A'}
        };
        new Solution().exist(board, "AAA");
    }
}

