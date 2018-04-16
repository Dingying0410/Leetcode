class Solution {
    public int numTrees(int n) {
        //G[i]: the number of trees that can be built from 1 .. i
        //G[i] = F(1, i) + F(2, i) + ... + F(i, i)
        int[] G = new int[n + 1];
        G[0] = G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                G[i] += G[j] * G[i - 1 - j];
            }
        }
        return G[n];
    }
}