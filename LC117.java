/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    //pre and current pointer
    //for every level, 
    //if pre = null, set pre, and start of this level -> served as the cur pointer for next level
    //else pre.next = cur
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        TreeLinkNode start = null;
        TreeLinkNode cur = root;
        TreeLinkNode pre = null;
        while (cur != null) {
            while (cur != null) {
                if (cur.left != null) {
                    if (pre == null) {
                        pre = cur.left;
                        start = pre;
                    } else {
                        pre.next = cur.left;
                        pre = cur.left;
                    }
                }
                if (cur.right != null) {
                    if (pre == null) {
                        pre = cur.right;
                        start = pre;
                    } else {
                        pre.next = cur.right;
                        pre = cur.right;
                    }
                }
                cur = cur.next;
            }
            cur = start;
            start = null;
            pre = null;
        }
    }
}