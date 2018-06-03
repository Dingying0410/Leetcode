/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    ListNode head;
    Random r;
    public Solution(ListNode head) {
        this.head = head;
        r = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode cur = head;
        int len = 1;
        int res = -1;
        while (cur != null) {
            if (r.nextInt(len++) == 0) {
                res = cur.val;
            }
            cur = cur.next;
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
