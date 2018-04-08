class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3)
            return 0;
        int res = 0, cur = 0;
        for (int i = 0; i + 2 < A.length; i++) {
            if (A[i + 1] - A[i] == A[i + 2] - A[i + 1]) {
                cur++;
                res += cur;
            } else {
                cur = 0;
            }
        }
        return res;
    }
}