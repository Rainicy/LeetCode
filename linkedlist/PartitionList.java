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
    public ListNode partition(ListNode head, int x) {
        // split head list to a smaller and not smaller two lists
        ListNode l1 = null;
        ListNode l2 = null;
        ListNode pL1 = null;
        ListNode pL2 = null;
        ListNode p = head;

        // go through whole head list, and split it into two lists
        while (p != null) {
            if (p.val < x) {    // insert to l1
                if (l1 == null) {
                    l1 = p;
                    pL1 = p;
                    p = p.next;
                    pL1.next = null;
                }
                else {
                    pL1.next = p;
                    p = p.next;
                    pL1 =  pL1.next;
                    pL1.next = null;
                }
            }
            else {  // insert to l2
                if (l2 == null) {
                    l2 = p;
                    pL2 = p;
                    p = p.next;
                    pL2.next = null;
                }
                else {
                    pL2.next = p;
                    p = p.next;
                    pL2 = pL2.next;
                    pL2.next = null;
                }
            }
        }

        // merge two lists
        if (l1 == null) {
            return l2;
        }
        else {
            pL1.next = l2;
        }
        return l1;
    }
}