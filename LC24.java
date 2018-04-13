/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode cur = head;
        ListNode pre = new ListNode(0);
        pre.next = cur.next;
        ListNode last = null;
        ListNode dummy = pre; 
        while (cur != null && cur.next != null) {
            ListNode temp = cur.next.next;
            pre.next = cur.next;
            cur.next.next = cur;
            pre = cur;
            cur.next = temp;
            cur = cur.next;
        }
        return dummy.next;
    }
}