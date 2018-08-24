/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public int numComponents(ListNode head, int[] G) {
        if (head == null)
            return 0;
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < G.length; i++) {
            set.add(G[i]);
        }
        while (head != null) {
            if (!set.contains(head.val)) {
                head = head.next;
                continue;
            }
            while (head != null && set.contains(head.val)) {
                head = head.next;
            }
            res++;
        }
        return res;
    }


}
