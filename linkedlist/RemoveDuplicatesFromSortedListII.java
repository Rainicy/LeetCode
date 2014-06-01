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
    public ListNode deleteDuplicates(ListNode head) {

        // set the p and prev
        ListNode p = head;
        head = null;
        ListNode prev = null;
        while (p != null) {
            Boolean ifDup = false;
            // check if the current p is duplicates or not
            ListNode pN = p.next;
            if (pN == null) { // the p is the last head
                if (prev == null) {
                    head = p;
                }
                else {
                    prev.next = p;
                }
                p = p.next;
                continue;
            }
            while (pN != null) {
                if (p.val == pN.val) {
                    ifDup = true;
                    pN = pN.next;
                }
                else {
                    break;
                }
            }
            // if p is duplicates, ignore this p
            if (ifDup) {
                p = pN;
            }
            else { // insert p to the list
                if (prev == null) {
                    head = p;
                    prev = p;
                }
                else {
                    prev.next = p;
                    prev = prev.next;
                }
                prev.next = null;
                p = pN;
            }
        }

        return head;
    }
}