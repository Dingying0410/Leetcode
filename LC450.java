/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Time: O(log n)
//Space: O(1)
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        else if (root.val == key) {
            return delete(root);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }
    
    public TreeNode delete(TreeNode root) {
        if (root == null)
            return null;
        else if (root.left == null && root.right == null) {
            root = null;
        } else if (root.left == null) {
            root = root.right;
        } else if (root.right == null) {
            root = root.left;
        } else {
            TreeNode smallest = smallest(root.right);
            root.val = smallest.val;
            root.right = deleteNode(root.right, smallest.val);
        }
        return root;
    }
    
    public TreeNode smallest(TreeNode root) {
        if (root == null)
            return null;
        TreeNode res = root;
        while (res.left != null) {
            res = res.left;
        }
        return res;
    }
}