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
    public ListNode rotateRight(ListNode head, int n) {

        if ((head == null) || (n == 0)) {   // no need rotate
            return head;
        }

        // get the total count of the nodes
        int count = 1;
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
            count++;
        }

        // n mod count
        n = n%count;
        if (n==0) { // no need rotate
            return head;
        }
        // right rotate equal to cut left(count-n) to the right
        p = head;
        for (int i=1; i<(count-n); i++) {
            p = p.next;
        }
        ListNode pNext = p.next;
        p.next = null;
        ListNode p1 = pNext;
        while (p1.next != null) {
            p1 = p1.next;
        }
        p1.next = head;
        head = pNext;

        return head;
    }
}