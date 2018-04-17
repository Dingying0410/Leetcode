class Solution {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O')
                dfs(board, i, 0, m, n);
            if (board[i][n - 1] == 'O')
                dfs(board, i, n - 1, m, n);
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O')
                dfs(board, 0, j, m, n);
            if (board[m - 1][j] == 'O')
                dfs(board, m - 1, j, m, n);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == 'Q')
                    board[i][j] = 'O';
            }
        }
    }
    
    public void dfs (char[][] board, int i, int j, int m, int n) {
        if (i < 0 || i == m || j < 0 || j == n || board[i][j] != 'O')
            return;
        board[i][j] = 'Q';
        int[] delta = {0, -1, 0, 1, 0};
        for (int k = 0; k < delta.length - 1; k++) {
            dfs(board, i + delta[k], j + delta[k + 1], m, n);
        }
    }
}