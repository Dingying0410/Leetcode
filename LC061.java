/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0)
            return head;
        //Find the k node from the end, move from the head by k
        //waht if k > len
        ListNode fast = head;
        int len = 1;
        for (int i = 0; i < k; i++) {
            if (fast.next == null) {
                k %= len;
                i = -1;
                fast = head;
            } else {
                len++;
                fast = fast.next;
            }
        }
        if (k == 0)
            return head;
        ListNode slow = new ListNode(0);
        slow.next = head;
        ListNode pre = new ListNode(0);
        pre.next = fast;
        System.out.println(fast.val);
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            pre = pre.next;
        }
        ListNode res = slow.next;
        slow.next = null;
        pre.next = head;
        return res;
    }

    //Version 2: get the length first, beat 96%
    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;
        ListNode fast = head;
        int len = 1;
        while (fast.next != null) {
            len++;
            fast = fast.next;
        }
        k %= len;
        if (k == 0) return head;
        k = len - k;
        ListNode pre = new ListNode(0);
        pre.next = head;
        for (int i = 0; i < k; i++) {
            pre = pre.next;
        }
        ListNode res = pre.next;
        pre.next = null;
        fast.next = head;
        return res;
    }
}