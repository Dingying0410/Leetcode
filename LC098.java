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
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (pre != null && pre.val >= root.val)
                    return false;
                pre = root;
                root = root.right;
            }
        }
        return true;
    }

    //Version 2: using dfs
    public boolean isValidBST(TreeNode root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    //if root.val < min, or root.val > max, return false
    //on left, update max (left < root.val); on right, update min (right > root.val)
    public boolean valid (TreeNode root, long min, long max) {
        if (root == null)
            return true;
        if (root.val >= max || root.val <= min) 
            return false;
        return valid(root.left, min, root.val) && valid(root.right, root.val, max);
    }
}