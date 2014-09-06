## Maximum Depth of Binary Tree

### Description

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

### Code
```java
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        // Recursive method
        if (root == null) {
            return 0;
        }
        else {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
}
```