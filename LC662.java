/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int max = 0;
    public int widthOfBinaryTree(TreeNode root) {
        int depth = depth(root);
        int[] start = new int[depth];
        int[] end = new int[depth];
        Arrays.fill(start, Integer.MAX_VALUE);
        Arrays.fill(end, Integer.MIN_VALUE);
        dfs(root, start, end, 0, 0);
        return max;
    }

    public int depth (TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }

    public void dfs (TreeNode root, int[] start, int[] end, int col, int level) {
        if (root == null)
            return;
        start[level] = Math.min(start[level], col);
        end[level] = Math.max(end[level], col);
        max = Math.max(end[level] - start[level] + 1, max);
        dfs(root.left, start, end, col * 2 + 1, level + 1);
        dfs(root.right, start, end, col * 2 + 2, level + 1);
    }
}
