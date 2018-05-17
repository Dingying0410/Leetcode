class Solution {
    public int numberOfPatterns(int m, int n) {
        int[][] skip = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[4][6] = skip[6][4] = 5;
        skip[7][9] = skip[9][7] = 8;
        skip[1][7] = skip[7][1] = 4;
        skip[2][8] = skip[8][2] = 5;
        skip[3][9] = skip[9][3] = 6;
        skip[1][9] = skip[9][1] = 5;
        skip[3][7] = skip[7][3] = 5;
        int total = 0;
        boolean[] used = new boolean[10];
        for (int i = 1; i <= 9; i++) {
            for (int j = m; j <= n; j++) {
                used[i] = true;
                total += helper(i, j, skip, used);
                used[i] = false;
            }
        }
        return total;
    }

    //the number of patterns that can be created using m keys from start
    public int helper (int start, int m, int[][] skip, boolean[] used) {
        if (m == 1)
            return 1;
        int total = 0;
        for (int i = 1; i <= 9; i++) {
            int jump = skip[start][i];
            if (!used[i] && (jump == 0 || (used[jump]))) {
                used[i] = true;
                total += helper(i, m - 1, skip, used);
                used[i] = false;
            }
        }
        return total;
    }
}
