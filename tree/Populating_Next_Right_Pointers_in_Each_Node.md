## Populating Next Right Pointers in Each Node 

### Description

Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL

### Code
```java
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        // using Queue, LinkedList as extra space
        LinkedList<TreeLinkNode> L = new LinkedList<TreeLinkNode>();
        L.add(root);
        
        LinkedList<TreeLinkNode> newL = new LinkedList<TreeLinkNode>();
        while (L.size() > 0) {
            TreeLinkNode p = L.removeFirst();
            while(L.size() > 0) {
                if (p.left != null) {
                    newL.add(p.left);
                    newL.add(p.right);
                }
                p.next = L.getFirst();
                p = L.removeFirst();
            }
            if (p.left != null) {
                newL.add(p.left);
                newL.add(p.right);
            }
            p.next = null;
           
            while (newL.size() > 0) {
                L.add(newL.removeFirst());
            }
        }
    }
}

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        
        if (root.left != null){
            root.left.next = root.right;
        }
        if (root.right != null && root.next!= null) {
            root.right.next = root.next.left;
        }
           
        connect(root.left);
        connect(root.right);
    }
}
```