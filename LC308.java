class NumMatrix {

    int[][] bits;
    int[][] nums;
    int m;
    int n;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return;
        m = matrix.length;
        n = matrix[0].length;
        bits = new int[m + 1][n + 1];
        nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }

    public void update(int row, int col, int val) {
        int delta = val - nums[row][col];
        nums[row][col] = val;
        for (int i = row + 1; i <= m; i += (i & (-i))) {
            for (int j = col + 1; j <= n; j += (j & (-j))) {
                bits[i][j] += delta;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumRange(row2, col2) - sumRange(row2, col1 - 1) - sumRange(row1 - 1, col2) + sumRange(row1 - 1, col1 - 1);
    }

    public int sumRange(int row, int col) {
        int sum = 0;
        for (int i = row + 1; i > 0; i -= (i & (-i))) {
            for (int j = col + 1; j > 0; j -= (j & (-j))) {
                sum += bits[i][j];
            }
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
