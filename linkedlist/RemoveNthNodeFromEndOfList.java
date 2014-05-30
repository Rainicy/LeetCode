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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        /* Set up to pointers(p1 & p2):
        ** p1 to get the Nth node from the begining.
        ** Once p1 get the correct position:
        **  set up p2 to the header, then p1 & p2 go through the list until
        **  p2 get to the trailer. The p2 position is the Nth from the end.
        */

        // check the list and n
        if ((head == null) || (n<=0)) {
            return head;
        }

        // trying to get the p1 position
        ListNode p1 = null;
        for (int i=0; i<n; i++) {   // trying to take one step forward
            if (p1 == null) {   // the first node: head
                p1 = head;
            }
            else {
                if (p1.next == null) {  // at the end of the list, n exceeds the length
                    return head;
                }
                else {
                    p1 = p1.next;   // one step forward
                }
            }
        }

        // Got the p1, set up p2, we also need one previous pointer to p2
        ListNode p2 = head;
        ListNode prev = null;
        while (p1.next != null) {   // trying to move to the last node
            // move p2 and prev
            if (prev == null) {
                prev = p2;
                p2 = p2.next;
            }
            else {
                prev = prev.next;
                p2 = p2.next;
            }
            /***Update the p1***/
            p1 = p1.next;
        }

        // Got the p1 and p2 positions, remove the node.
        if (prev == null) {  // remove the head
            head = head.next;
            p2.next = null;
        }
        else {  // remove the p2
            prev.next = p2.next;
            p2.next = null;
        }

        return head;
    }
}