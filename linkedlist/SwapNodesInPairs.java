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
    public ListNode swapPairs(ListNode head) {

        ListNode p = head;
        ListNode prev = null;
        while (p != null) { // starting swap the next two nodes.
            if (p.next == null) {   // only one node left, break
                break;
            }
            else {
                ListNode pN = p.next;
                // swap
                p.next = pN.next;
                pN.next = p;
                if (prev != null) {
                    prev.next = pN;
                }

                /**if p is the header, need set the header to the first**/
                if (p == head) {
                    head = pN;
                }
                // update p
                prev = p;
                p = p.next;

            }
        }

        return head;
    }
}