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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null)
            return root;
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }

    //Version 2: iterative
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode pre = null;
        TreeNode cur = root;
        TreeNode nextRight = null;
        while (cur != null) {
            TreeNode next = cur.left;
            cur.left = nextRight;
            nextRight = cur.right;
            cur.right = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}