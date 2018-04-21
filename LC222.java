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
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int h = height(root);
        int right = height(root.right);
        if (h == right + 1) {
            return (1 << right) + countNodes(root.right);
        } else {
            return (1 << right) + countNodes(root.left);
        }
    }
    
    public int height (TreeNode root) {
        if (root == null)
            return 0;
        return 1 + height(root.left);
    }
}