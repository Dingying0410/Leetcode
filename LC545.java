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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        res.add(root.val);
        leftBoundary(res, root.left);
        leaves(res, root.left);
        leaves(res, root.right);
        rightBoundary(res, root.right);
        return res;
    }

    public void leftBoundary (List<Integer> res, TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return;
        res.add(root.val);
        if (root.left == null)
            leftBoundary(res, root.right);
        else
            leftBoundary(res, root.left);
    }

    public void rightBoundary (List<Integer> res, TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return;
        if (root.right == null)
            rightBoundary(res, root.left);
        else
            rightBoundary(res, root.right);
        res.add(root.val);
    }

    public void leaves (List<Integer> res, TreeNode root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            res.add(root.val);
        leaves(res, root.left);
        leaves(res, root.right);
    }
}
