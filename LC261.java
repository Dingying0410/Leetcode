class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] roots = new int[n];
        Arrays.fill(roots, -1);
        for (int [] edge : edges) {
            int a = findRoot(roots, edge[0]);
            int b = findRoot(roots, edge[1]);
            if (a == b)
                return false;
            roots[b] = a;
        }
        return edges.length == n - 1;
    }

    public int findRoot(int[] roots, int i) {
        if (roots[i] == -1)
            return i;
        return findRoot(roots, roots[i]);
    }
}
