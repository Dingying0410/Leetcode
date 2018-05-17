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
    public List<List<String>> printTree(TreeNode root) {
        //columns = 2 ^ row - 1
        //queue to record the column number
        int depth = depth(root);
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<String>();
        int cols = (int)Math.pow(2, depth) - 1;
        for (int i = 0; i < cols; i++) {
            temp.add("");
        }
        for (int i = 0; i < depth; i++) {
            res.add(new ArrayList<>(temp));
        }
        printTree(res, 0, 0, cols, root);
        return res;
    }

    public void printTree (List<List<String>> res, int level, int colStart, int colEnd, TreeNode root) {
        if (root == null)
            return;
        int col = (colStart + colEnd) / 2;
        res.get(level).set(col, root.val + "");
        printTree(res, level + 1, colStart, col - 1, root.left);
        printTree(res, level + 1, col + 1, colEnd, root.right);
    }

    public int depth (TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
} 
