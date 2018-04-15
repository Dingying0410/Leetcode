class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        //startRow = 0, endCol = n - 1 -> startRow = 1
        //endCol = n - 1, endRow = n - 1 -> endCol = n - 2 = 1
        //endRow = n - 1, startCol = 0 -> endRow = n - 2 = 1
        //startCol = 0, startRow = 1 -> startCol = 1
        //startRow = 1, endCol = 1-> startRow = 2
        
        
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0)
            return res;
        int startRow = 0, startCol = 0;
        int endRow = matrix.length - 1, endCol = matrix[0].length - 1;
        while (startRow <= endRow && startCol <= endCol) {
            for (int j = startCol; j <= endCol; j++) {
                res.add(matrix[startRow][j]);
            }
            startRow++;
            for (int i = startRow; i <= endRow; i++) {
                res.add(matrix[i][endCol]);
            }
            endCol--;
            if (startRow <= endRow) {
                for (int j = endCol; j >= startCol; j--) {
                    res.add(matrix[endRow][j]);
                }
                endRow--;
            }
            if (startCol <= endCol) {
                for (int i = endRow; i >= startRow; i--) {
                    res.add(matrix[i][startCol]);
                }
                startCol++;
            }
        }
        return res;
    }
}