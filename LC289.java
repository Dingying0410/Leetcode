class Solution {
    public void gameOfLife(int[][] board) {
        //00->10 01->11
        if (board.length == 0 || board[0].length == 0)
            return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = countLives(board, i, j, m, n);
                if (board[i][j] == 0) {
                    if (lives == 3)
                        board[i][j] = 2;
                } else {
                    if (lives == 3 || lives== 2)
                        board[i][j] = 3;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    public int countLives(int[][] board, int i, int j, int m, int n) {
        int lives = 0;
        for (int x = Math.max(0, i - 1); x <= Math.min(i + 1, m - 1); x++) {
            for (int y = Math.max(0, j - 1); y <= Math.min(j + 1, n - 1); y++) {
                if (x == i && y == j)
                    continue;
                if ((board[x][y] & 1) == 1)
                    lives++;
            }
        }
        return lives;
    }
}
