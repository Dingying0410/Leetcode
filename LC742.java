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
    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        TreeNode target = search(root, k, map);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        Set<Integer> visited = new HashSet<>();
        visited.add(target.val);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left == null && cur.right == null) {
                return cur.val;
            }
            if (cur.left != null && !visited.contains(cur.left.val)) {
                queue.add(cur.left);
                visited.add(cur.left.val);
            }
            if (cur.right != null && !visited.contains(cur.right.val)) {
                queue.add(cur.right);
                visited.add(cur.right.val);
            }
            if (map.containsKey(cur) && !visited.contains(map.get(cur).val)) {
                queue.add(map.get(cur));
                visited.add(map.get(cur).val);
            }
        }
        return -1;
    }

    public TreeNode search(TreeNode root, int k, Map<TreeNode, TreeNode> map) {
        if (root == null)
            return null;
        if (root.val == k) {
            return root;
        }
        if (root.left != null) {
            map.put(root.left, root);
            TreeNode left = search(root.left, k, map);
            if (left != null)
                return left;
        }
        if (root.right != null) {
            map.put(root.right, root);
            TreeNode right = search(root.right, k, map);
            if (right != null)
                return right;
        }
        return null;
    }
}
