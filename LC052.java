class Solution {
    int res = 0;
    public int totalNQueens(int n) {
        if (n == 0)
            return 0;
        solve(0, n, new HashSet<Integer>(), new HashSet<Integer>(), new HashSet<Integer>());
        return res;
    }
    
    //solve each row, if row == n, then add the res by 1
    public void solve (int row, int n, Set<Integer> cols, Set<Integer> diag1, Set<Integer> diag2) {
        if (row == n) {
            res++;
            return;
        }
        for (int j = 0; j < n; j++) {
            if (!cols.contains(j) && !diag1.contains(j - row) && !diag2.contains(j + row)) {
                cols.add(j);
                diag1.add(j - row);
                diag2.add(j + row);
                solve(row + 1, n, cols, diag1, diag2);
                cols.remove(j);
                diag1.remove(j - row);
                diag2.remove(j + row);
            }
        }
    }

    //Version 2: use boolean array instead of set, then it will be much faster
    int res = 0;
    public int totalNQueens2(int n) {
        if (n == 0)
            return 0;
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n];  //the diagnal like (0, 0), (1, 1) .. the max can be n - 1 - 0, and the min can be 0 - (n - 1) = -n + 1, so add n to it 
        boolean[] diag2= new boolean[2 * n]; //[0, 2], [1, 1], max can be 2n - 2
        solve(0, n, cols, diag1, diag2);
        return res;
    }
    
    //solve each row, if row == n, then add the res by 1
    public void solve2 (int row, int n, boolean[] cols, boolean[] diag1, boolean[] diag2) {
        if (row == n) {
            res++;
            return;
        }
        for (int j = 0; j < n; j++) {
            if (!cols[j] && !diag1[j - row + n] && !diag2[j + row]) {
                cols[j] = diag1[j - row + n] = diag2[j + row] = true;
                solve(row + 1, n, cols, diag1, diag2);
                cols[j] = diag1[j - row + n] = diag2[j + row] = false;
            }
        }
    }
}