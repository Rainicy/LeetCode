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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // if one of them is null, return another one.
        if ((l1 == null) || (l2 == null)) {
            return (l1 == null) ? l2 : l1;
        }

        // if both of them are not null, add them. 
        /******* initail null *******/
        ListNode l = null;     //list node to store the sum 
        // set three pointers to the list nodes
        ListNode pL = null;
        ListNode pL1 = l1;
        ListNode pL2 = l2;
        Boolean ifCarry = false;
        while ((pL1 != null) || (pL2 != null)) {
            // get the two digits in two list
            int dig1 = (pL1 == null) ? 0 : pL1.val;
            int dig2 = (pL2 == null) ? 0 : pL2.val;

            // calculate the current sum digit and if have carry
            int sum = dig1 + dig2 + (ifCarry ? 1 : 0);
            // build the head node
            if (l == null) {
                l = new ListNode(sum%10);
                pL = l;
            }
            else {
                pL.next = new ListNode(sum%10);
                pL = pL.next;
            }

            // if has carry
            ifCarry = (sum > 9) ? true : false;

            // update the pointers
            if (pL1 != null) {
                pL1 = pL1.next;
            }
            if (pL2 != null) {
                pL2 = pL2.next;
            }
        }

        // if has carry 
        if (ifCarry) {
            pL.next = new ListNode(1);
        }

        return l;

    }
}