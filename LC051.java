class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], '.');
        }
        solve(res, board, 0, n);
        return res;
    }
    
    
    //check valid
    public boolean valid (char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q')
                return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }
        //[2, 0], [1, 1], [0, 2]
        for (int i = row - 1, j = row + col - i; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }
    
    //solve each row
    public void solve (List<List<String>> res, char[][] board, int row, int n) {
        if (row == n) {
            List<String> list = boardToList(board);
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = 0; j < board[row].length; j++) {
            if (board[row][j] == '.' && valid(board, row, j)) {
                board[row][j] = 'Q';
                solve(res, board, row + 1, n);
                board[row][j] = '.';
            }
        }
    }
    
    //convert board to list
    public List<String> boardToList(char[][] board) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board[i].length; j++) {
                sb.append(board[i][j]);
            }
            list.add(sb.toString());
        }
        return list;
    }
}