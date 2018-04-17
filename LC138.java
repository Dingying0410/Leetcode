/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
        //Copy the list, like 1->1->2->2
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode temp = cur.next;
            cur.next = new RandomListNode(cur.label);
            cur.next.next = temp;
            cur = temp;
        }
        //Assign random pointer
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        //Restore and build the result
        cur = head;
        RandomListNode copy = new RandomListNode(0);
        RandomListNode res = copy;
        while (cur != null) {
            copy.next = cur.next;
            cur.next = cur.next.next;
            cur = cur.next;
            copy = copy.next;
        }
        return res.next;
    }
}