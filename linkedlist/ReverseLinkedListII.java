/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // find m-1 and n + 1 position and insert the nodes to the right part
        ListNode Prev = null;
        ListNode Next = null;
        ListNode p = head;
        ListNode h = null;

        // try to get the position
        for (int i=1; i<=n; i++) {
            if (i == (m-1)) {
                Prev = p;
                h = p.next;
            }
            if (i == (n)) {
                Next = p.next;
                p.next = null;
            }
            p = p.next;
        }

        // go through the list starting with h
        if (Prev == null) {
            h = head;
        }
        ListNode p1 = h;
        while (p1 != null) {
            ListNode temp = p1;
            p1 = p1.next;
            temp.next = Next;
            Next = temp;
        }

        // merge Prev and Next
        if (Prev == null) {
            return Next;
        }
        else {
            Prev.next = Next;
        }
        return head;
    }
}