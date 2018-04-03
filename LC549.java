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
    
    public int[] helper (TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int inc = 1, dec = 1;
        int[] res = new int[2];
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        if (root.left != null) {
            if (root.val == root.left.val + 1) {
                inc = 1 + left[0];
            }
            else if (root.val == root.left.val - 1) {
                dec = 1 + left[1];
            }
        }
        if (root.right != null) {
            if (root.val == root.right.val + 1) {
                inc = Math.max(1 + right[0], inc);
            }
            else if (root.val == root.right.val - 1) {
                dec = Math.max(1 + right[1], dec);
            }
        }
        max = Math.max(dec + inc - 1, max);
        res[0] = inc;
        res[1] = dec;
        return res;
    }
}