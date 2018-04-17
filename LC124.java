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
    //helper method, get the maximum path sum on left, right
    //maximum sum starting from current root, compare with the global max
    //return root.val + one path 
    
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
    
    public int helper (TreeNode root) {
        if (root == null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        max = Math.max(root.val + Math.max(left, 0) + Math.max(right, 0), max);
        return root.val + Math.max(left, Math.max(right, 0));
    }
}