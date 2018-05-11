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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        //Build a increasing stack and a decreasing stack
        Stack<Integer> inc = new Stack<>();
        Stack<Integer> dec = new Stack<>();
        //Build the stack
        helper(inc, true, target, root);
        helper(dec, false, target, root);
        while (res.size() < k) {
            if (inc.isEmpty()) {
                res.add(dec.pop());
            } else if (dec.isEmpty()) {
                res.add(inc.pop());
            } else if (inc.peek() - target < target - dec.peek()) {
                res.add(inc.pop());
            } else {
                res.add(dec.pop());
            }
        }
        return res;
    }

    public void helper (Stack<Integer> stack, boolean inc, double target, TreeNode root) {
        if (root == null)
            return;
        helper(stack, inc, target, inc? root.right : root.left);
        if ((inc && root.val < target) || (!inc && root.val >= target))
            return;
        stack.push(root.val);
        helper(stack, inc, target, inc? root.left : root.right);
    }
}
