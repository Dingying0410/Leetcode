/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n)
            return head;
        ListNode preM = new ListNode(0);
        preM.next = head;
        ListNode res = preM;
        for (int i = 1; i < m; i++) {
            preM = preM.next;
        }
        ListNode cur = preM.next;
        ListNode nNode = cur;
        ListNode pre = null;
        for (int i = m; i <= n; i++) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        preM.next = pre;
        nNode.next = cur;
        return res.next;
    }
}