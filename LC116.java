/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        while (root != null) {
            TreeLinkNode next = root.left;
            while (root != null) {
                if (root.left != null) {
                    root.left.next = root.right;
                }
                if (root.right != null) {
                    root.right.next = root.next == null? null : root.next.left;
                }
                root = root.next;
            }
            root = next;
        }
    }
}