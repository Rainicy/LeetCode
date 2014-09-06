## Linked List Cycle

### Description
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?

### Code
```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // use a faster pointer and a slower pointer 
        ListNode faster = head;
        ListNode slower = head; 
        
        while (faster != null) {
            faster = faster.next;
            if (faster != null) {
                faster = faster.next;
            }
            else {
                return false;
            }
            slower = slower.next;
            
            if (slower == faster) {
                return true;
            }
        }
        return false;
    }
}
```