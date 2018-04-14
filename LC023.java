/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        //1->2 1->3 4 ---> 1 -> 1 -> 2 -> 3 -> 4
        if (lists == null || lists.length == 0)
            return null;
        return divide(0, lists.length - 1, lists);
    }
    
    public ListNode divide(int left, int right, ListNode[] lists) {
        if (left > right)
            return null;
        else if (left == right)
            return lists[left];
        ListNode A = divide(left, (left + right) / 2, lists);
        ListNode B = divide((left + right) / 2 + 1, right, lists);
        return merge(A, B);
    }
    
    public ListNode merge(ListNode A, ListNode B) {
        if (A == null)
            return B;
        if (B == null)
            return A;
        if (A.val < B.val) {
            A.next = merge(A.next, B);
            return A;
        } else {
            B.next = merge(A, B.next);
            return B;
        }
    }
}