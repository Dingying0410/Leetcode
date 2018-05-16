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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<Integer> cols = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        cols.add(0);
        int min = 0, max = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int col = cols.poll();
            min = Math.min(min, col);
            max = Math.max(max, col);
            if (!map.containsKey(col))
                map.put(col, new ArrayList<>());
            map.get(col).add(cur.val);
            if (cur.left != null) {
                queue.add(cur.left);
                cols.add(col - 1);
            }
            if (cur.right != null) {
                queue.add(cur.right);
                cols.add(col + 1);
            }
        }
        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}
