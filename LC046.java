class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> rows = new HashSet<>();
            Set<Character> cols = new HashSet<>();
            Set<Character> boxes = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !rows.add(board[i][j]))
                    return false;
                if (board[j][i] != '.' && !cols.add(board[j][i]))
                    return false;
                int row = 3 * (i / 3) + j % 3; //row = 0, 1, 2, 0, 1, 2 ... or 4, 5, 6, 4, 5, 6
                int col = 3 * (i % 3) + j / 3; //col = 0, 0, 0, 1, 1, 1, 2, 2, 2 
                if (board[row][col] != '.' && !boxes.add(board[row][col]))
                    return false;
            }
        }
        return true;
    }
}