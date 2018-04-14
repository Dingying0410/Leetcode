class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        flip(matrix);
    }
    
    public void flip (int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                swap(i , j, i, matrix.length - 1 - j, matrix);
            }
        }
    }
    
    public void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                System.out.println(i + " " + j);
                swap(i, j, j, i, matrix);
            }
        }
    }
    
    public void swap(int i1, int j1, int i2, int j2, int[][] matrix) {
        int temp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = temp;
    }
}