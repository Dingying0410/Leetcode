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
    //3 -> level 0, psuh 9, 20
    //9, 20 -> level 1, push 15, 7
    //15, 7 -> level 2
    //BFS
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0) {
                size--;
                TreeNode cur = queue.poll();
                if (level % 2 == 0) {
                    list.add(cur.val);
                } else {
                    list.add(0, cur.val);
                }
                if (cur.left != null) {
                    queue.add(cur.left);
                } 
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            level++;
            res.add(new ArrayList<>(list));
        }
        return res;
    }
}