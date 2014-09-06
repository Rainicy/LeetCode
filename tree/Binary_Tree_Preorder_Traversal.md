## Binary Tree Preorder Traversal

### Description
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
	   1
	    \
	     2
	    /
	   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> L = new ArrayList<Integer>();
        if (root == null) {
            return L;
        }
        
        Stack<TreeNode> S = new Stack<TreeNode>();
        S.push(root);
        
        while (!S.empty()) {
            TreeNode node = S.pop();
            L.add(node.val);
            
            if(node.right != null) {
                S.push(node.right);
            }
            if(node.left != null) {
                S.push(node.left);
            }
        }
        
        return L;
    }
    
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     List<Integer> L = new ArrayList<Integer>();
        
    //     if (root == null) {
    //         return L;
    //     }
        
    //     preorderHelper(root, L);
    //     return L;
    // }
    
    // private void preorderHelper(TreeNode node, List L) {
    //     if (node == null) {
    //         return;
    //     }
    //     L.add(node.val);
    //     preorderHelper(node.left, L);
    //     preorderHelper(node.right, L);
    // }
}
```