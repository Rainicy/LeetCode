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
        while (it.hasNext()) {
            /*** try another way to merge the current list to the head ***/
            ListNode cur = it.next();
            if (head == null) {
                head = cur;
            }
            else {
                ListNode pHead = head;
                ListNode prevHead = null;
                while (cur != null) {
                    if (pHead == null) {   // merge all the nodes in the list to head list
                        prevHead.next = cur;
                        cur = null;
                    }
                    else {
                        ListNode node = cur;    // get the head node in the cur list
                        cur = cur.next;
                        node.next = null;
                        // find the correct position to insert
                        while ((pHead != null) && (node.val > pHead.val)) {
                            // move the pHead and preHead forward
                            if (prevHead == null) {
                                prevHead = head;
                                pHead = pHead.next;
                            }
                            else {
                                prevHead = prevHead.next;
                                pHead = pHead.next;
                            }
                        }
                        // got the correct position
                        if (prevHead == null) {
                            prevHead = node;
                        }
                        else {
                            prevHead.next = node;
                            prevHead = prevHead.next;
                        }
                        node.next = pHead;
                    }
                }
            }
        }

        return head;
    }
}