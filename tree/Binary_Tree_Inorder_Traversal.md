## Binary Tree Inorder Traversal

### Description

Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?

confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

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
    public List<Integer> inorderTraversal(TreeNode root) { 
        List<Integer> L = new ArrayList<Integer>(); 
        
        if (root == null) {
            return L;
        }
        
        Stack<TreeNode> S = new Stack<TreeNode>();
        TreeNode node = root;
        
        while (!S.empty() || (node != null)) {
            if (node != null) {
                S.push(node);
                node = node.left;
            }
            // no more left child, need visit this node.
            else {
                node = S.pop();
                L.add(node.val);
                node = node.right;
            }
        }
        return L;
    }
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> list = new LinkedList<Integer>();
        
    //     // recursively traversal
    //     inorderCursive(root, list);
    //     return list;
    // }
    
    // protected void inorderCursive(TreeNode node, List<Integer> L) {
    //     if (node == null) {
    //         return;
    //     } 
    //     if (node.left != null) {
    //         inorderCursive(node.left, L);
    //     }
    //     L.add(node.val);
    //     if (node.right != null) {
    //         inorderCursive(node.right, L);
    //     }
    // }
}
```
