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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /* Create a new list. */
        ListNode l = null;
        ListNode pL = null;

        // go through the list
        while ((l1 != null) || (l2 != null)) {
            // set a flag to indicate which list node is the one to merge
            Boolean ifMergeL1 = false;

            if (l1 == null) {   // merge l2
                ifMergeL1 = false;
            }
            else if (l2 == null) {  // merge l1
                ifMergeL1 = true;
            }
            else {  // both of l1 and l2 are not null, merge the smaller one
                ifMergeL1 = (l1.val <= l2.val) ? true : false;
            }

            // add the node to the new list and remove it from the old list
            if (ifMergeL1) {
                if (l == null) { // insert the first one to the new list
                    l = l1;
                    l1 = l1.next;
                    pL = l;
                }
                else {
                    pL.next = l1;
                    l1 = l1.next;
                    pL = pL.next;
                }
                pL.next = null;
            }
            else {
                if (l == null) { // insert the first one to the new list
                    l = l2;
                    l2 = l2.next;
                    pL = l;
                }
                else {
                    pL.next = l2;
                    l2 = l2.next;
                    pL = pL.next;
                }
                pL.next = null;
            }
        }

        return l;
    }
}