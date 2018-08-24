/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};
*/

//Case 1: cur.val < val < cur.next.val
//Case 2: cur.val > cur.next.val: insert at end of the list, like insert 0 or 5 to 1,2,3,4
//Case 3: the linked list has equal values
class Solution {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node temp = new Node(insertVal, null);
            temp.next = temp;
            return temp;
        }
        Node cur = head;
        while (true) {
            if (cur.val <= insertVal && insertVal < cur.next.val) {
                insertAfter(cur, insertVal);
                break;
            } else if (cur.val > cur.next.val) {
                if (insertVal >= cur.val || insertVal <= cur.next.val) {
                    insertAfter(cur, insertVal);
                    break;
                }
            } else if (cur.next == head) {
                insertAfter(cur, insertVal);
                break;
            }
            cur = cur.next;
        }
        return head;
    }

    public void insertAfter(Node cur, int val) {
        cur.next = new Node(val, cur.next);
    }
}
