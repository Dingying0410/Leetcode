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
    //Define inStart, inEnd, posStart, posEnd for left, right subtrees
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, map);
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder, int instart, int inend, int posstart, int posend, Map<Integer, Integer> map) {
        if (instart > inend || posstart > posend)
            return null;
        int rootIndex = map.get(postorder[posend]);
        int rightSize = inend - rootIndex;
        TreeNode left = buildTree(inorder, postorder, instart, rootIndex - 1, posstart, posend - rightSize - 1, map);
        TreeNode right = buildTree(inorder, postorder, rootIndex + 1, inend, posend - rightSize, posend - 1, map);
        TreeNode root = new TreeNode(inorder[rootIndex]);
        root.left = left;
        root.right = right;
        return root;
    }
}