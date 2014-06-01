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
    public ListNode reverseKGroup(ListNode head, int k) {

        // check k
        if (k < 2) {
            return head;
        }

        // set up prev and next group pointers, and current one
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;
        ListNode p = head;

        // Reverse whole linked list
        while (p != null) {
            // check if we can get k ListNodes in rest of list
            // if so, we try to reverse this k ListNodes,
            // otherwise, we stop reversing.
            // after this loop, p will point the last node in the group
            for (int i=0; i<k-1; i++) {
                if (p != null) {
                    p = p.next;
                }
                else {
                    break;
                }
            }

            // Got the k nodes in crrent group
            if (p != null) {
                // set next group
                next = p.next;
                p.next = null;
                // reverse current group
                curr = reverseList(curr);

                // joint the prev group and next group
                ListNode pCurr = curr;
                while (pCurr.next != null) {
                    pCurr = pCurr.next;
                }
                if (prev == null) {
                    head = curr;
                }
                else {
                    prev.next = curr;
                }
                pCurr.next = next;
                prev = pCurr;
                curr = next;
                p = next;
            }
        }
        return head;
    }

    /**
     * By given the header, reverse the list and return the new header.
     */
    public ListNode reverseList(ListNode head) {
        ListNode p = head;
        ListNode node = null;
        Stack<ListNode> S = new Stack<ListNode>();
        // push nodes
        while (p!=null) {
            node = p;
            p = p.next;
            node.next = null;
            S.push(node);
        }
        // pop nodes get new linked list
        ListNode l = null;
        while (!S.isEmpty()) {
            node = S.pop();
            if (l == null) {
                l = node;
                p = l;
            }
            else {
                p.next = node;
                p = p.next;
            }
        }

        return l;
    }
}