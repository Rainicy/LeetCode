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
    public ListNode mergeKLists(List<ListNode> lists) {

        // if lists is null
        if ((lists == null)) {
            return null;
        }

        // Assume we can modify the given ListNode in the lists
        ListIterator<ListNode> it = lists.listIterator();
        ListNode head = null;
        while (it.hasNext()) {  // traversal the lists
            ListNode curList = it.next();

            // if the head is null
            if (head == null) {
                head = curList;
            }
            else {
                // merge the Kth list and the head to the newHead
                ListNode newHead = null;
                ListNode pNewHead = null;
                ListNode pHead = head;
                ListNode pCurList = curList;
                while ((pCurList != null) || (pHead != null)) {
                    /****if one of the list is null merge another entire list****/
                    if (pCurList == null) {
                        if (newHead == null) {
                            newHead = head;
                        }
                        else {
                            pNewHead.next = pHead;
                        }
                        break;
                    }
                    else if (pHead == null) {
                        if (newHead == null) {
                            newHead = curList;
                        }
                        else {
                            pNewHead.next = pCurList;
                        }
                        break;
                    }
                    else {
                        if (compare(pHead, pCurList)) { // merge the pHead to the new list
                            if (newHead == null) {
                                newHead = pHead;
                                pNewHead = newHead;
                            }
                            else {
                                pNewHead.next = pHead;
                                pNewHead = pNewHead.next;
                            }
                            pHead = pHead.next;
                            pNewHead.next = null;
                        }
                        else {  // merge the pCurList
                            if (newHead == null) {
                                newHead = pCurList;
                                pNewHead = newHead;
                            }
                            else {
                                pNewHead.next = pCurList;
                                pNewHead = pNewHead.next;
                            }
                            pCurList = pCurList.next;
                            pNewHead.next = null;
                        }
                    }
                }
                // update the head
                head = newHead;
                newHead = null;
            }
        }

        return head;
    }

    /**
     * 1) If l1.val is not bigger than l2.val, return true; otherwise false.
     */
    public Boolean compare(ListNode l1, ListNode l2) {
        return l1.val <= l2.val;
    }
}