class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return matrix;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] > 0)
                    res[i][j] = Integer.MAX_VALUE - 1;
                if (i > 0 && res[i - 1][j] < Integer.MAX_VALUE) {
                    res[i][j] = Math.min(res[i - 1][j] + 1, res[i][j]);
                }
                if (j > 0 && res[i][j - 1] < Integer.MAX_VALUE) {
                    res[i][j] = Math.min(res[i][j - 1] + 1, res[i][j]);
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i < m - 1 && res[i + 1][j] < Integer.MAX_VALUE)
                    res[i][j] = Math.min(res[i + 1][j] + 1, res[i][j]);
                if (j < n - 1 && res[i][j + 1] < Integer.MAX_VALUE) 
                    res[i][j] = Math.min(res[i][j + 1] + 1, res[i][j]);
            }
        }
        return res;
    }
}