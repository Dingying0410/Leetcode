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
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.left);
        flatten(root.right);
        
        if (root.left != null) {
            TreeNode left = root.left;
            TreeNode leftStart = left;
            TreeNode rightMost = left;
            while (left != null && left.right != null) {
                rightMost = left.right;
                left = left.right;
            }
            root.left = null;
            rightMost.right = root.right;
            root.right = leftStart;
        }
    }
}