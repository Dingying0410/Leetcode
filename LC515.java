// You need to find the largest value in each row of a binary tree.

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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.val > max) {
                    max = cur.val;
                }
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
            res.add(max);
        }
        return res;
    }
}