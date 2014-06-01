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

        ListNode p = head;
        while (p!=null) {
            ListNode pN = p.next;
            if (pN == null) {
                p = p.next;
                continue;
            }
            while (pN != null) {
                if (p.val == pN.val) {
                    pN = pN.next;
                }
                else {
                    p.next = pN;
                    p = pN;
                    break;
                }
            }
            if (pN == null) {
                p.next = pN;
            }
        }

        return head;
    }
}