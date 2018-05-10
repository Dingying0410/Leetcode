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
    public int longestConsecutive(TreeNode root) {
        helper(root);
        return max;
    }
    
    public int helper (TreeNode root) {
        if (root == null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int curMax = 1;
        if (root.left != null) {
            if (root.left.val == root.val + 1) {
                curMax = 1 + left;
            }
        }
        if (root.right != null) {
            if (root.right.val == root.val + 1) {
                curMax = Math.max(curMax, 1 + right);
            }
        }
        max = Math.max(curMax, max);
        return curMax;
    }
}