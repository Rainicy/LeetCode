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

        int k = lists.size();
        if (k == 0) {
            return null;
        }

        /***Using the heap to stored the nodes***/
        PriorityQueue<ListNode> heap=new PriorityQueue<ListNode>(k,new Comparator<ListNode>()
        {
            public int compare(ListNode l1,ListNode l2){
                return l1.val-l2.val;
            }});

        // stored all the headers
        for (int i=0; i<k; i++) {
            if (lists.get(i) != null) {
                heap.add(lists.get(i));
            }
        }

        // new list head head 
        ListNode head = null;
        ListNode p = null;

        while (!heap.isEmpty()) {
            // pop the minimum node
            ListNode minNode = heap.poll();
            // insert the minNode to the new list
            if (head == null) {
                head = minNode;
                p = head;
            }
            else {
                p.next = minNode;
                p = p.next;
            }
            // add the next node after minNode to the heap, if exists
            if (minNode.next != null) {
                heap.add(minNode.next);
            }
        }
        return head;
    }
}