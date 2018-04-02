class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board.length == 0 || board[0].length == 0)
            return board;
        dfs(board, click[0], click[1], board.length, board[0].length);
        return board;
    }
    
     public void dfs (char[][] board, int x, int y, int m, int n) {
         if (x == m || x < 0 || y == n || y < 0) {
             return;
         }
         if (board[x][y] == 'M') {
             board[x][y] = 'X';
         } else if (board[x][y] == 'E') {
             int count = 0;
             for (int i = Math.max(0, x - 1); i <= Math.min(m - 1, x + 1); i++) {
                 for (int j = Math.max(0, y - 1); j <= Math.min(n - 1, y + 1); j++) {
                     if (i == x && j == y)
                         continue;
                     if (board[i][j] == 'M') {
                         count++;
                     }
                 }
             }
             if (count == 0) {
                 board[x][y] = 'B';
                 for (int i = Math.max(0, x - 1); i <= Math.min(m - 1, x + 1); i++) {
                     for (int j = Math.max(0, y - 1); j <= Math.min(n - 1, y + 1); j++) {
                         if (i == x && j == y)
                             continue;
                         if (board[i][j] == 'E') {
                             dfs(board, i, j, m, n);
                         }
                     }
                }
             }
             else {
                 board[x][y] = (char)(count + '0');
             }
         }
     }
}