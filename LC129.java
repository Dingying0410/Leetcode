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
    //do a dfs on two children for each root, add the root.val to the path sum
    //path sum = sum * 10 + root.val
    //when meet the leaf node
    
    //root = 1, 
    //sum(left, 1), sum(right, 1)
    
    //left: leaf node, sum += 12 -> 12 return
    //right: leaf node, sum += 13 -> 25 return
    
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        sum(root, 0);
        return sum;
    }
    
    public void sum (TreeNode root, int pathSum) {
        if (root == null) 
            return;
        if (root.left == null && root.right == null) {
            sum += pathSum * 10 + root.val;
            return;
        }
        sum(root.left, pathSum * 10 + root.val);
        sum(root.right, pathSum * 10 + root.val);
    }
}