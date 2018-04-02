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
    public TreeNode str2tree(String s) {
        return helper(s);
    }
    
    public TreeNode helper (String s) {
        if (s.length() == 0)
            return null;
        int idx = s.indexOf('(');
        if (idx == -1) {
            return new TreeNode (Integer.valueOf(s));
        }
        String num = s.substring(0, idx);
        if (num.length() == 0)
            return null;
        TreeNode root = new TreeNode (Integer.valueOf(num));
        int count = 0;
        for (int i = idx; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }
            if (count == 0) {
                String left = s.substring(idx + 1, i);
                int next = s.indexOf('(', i + 1);
                String right = "";
                if (next != -1) {
                    right = s.substring(next + 1, s.length() - 1);
                }
                root.left = helper(left);
                root.right = helper(right);
                break;
            }
        }
        return root;
    }
}