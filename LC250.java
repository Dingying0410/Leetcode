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
    int res = 0;
    public int countUnivalSubtrees(TreeNode root) {
        univalTree(root);
        return res;
    }
    
    public boolean univalTree (TreeNode root) {
        if (root == null)
            return true;
        boolean left = univalTree(root.left);
        boolean right = univalTree(root.right);
        if (!left || !right)
            return false;
        if ((root.left != null && root.left.val != root.val) || (root.right != null && root.right.val != root.val))
            return false;
        res++;
        return true;
    }
}