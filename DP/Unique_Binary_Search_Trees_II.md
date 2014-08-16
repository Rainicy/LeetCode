## Unique Binary Search Trees II

### Description

Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

	1         3     3      2      1
	\       /     /      / \      \
	 3     2     1      1   3      2
	/     /       \                 \
	2     1         2                 3


### Code
```java

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        // It's the similar problem with Unique BST.
        // refer: http://www.cnblogs.com/jdflyfly/p/3819345.html
        return generateTreesHelper(1, n);
    }

    private List<TreeNode> generateTreesHelper(int left, int right) {
        List<TreeNode> L = new ArrayList<TreeNode>();
        if (left > right) {
            L.add(null);
            return L;
        }

        List<TreeNode> leftSubTree = new ArrayList<TreeNode>();
        List<TreeNode> rightSubTree = new ArrayList<TreeNode>();
        for (int i=left; i<=right; i++) {
            leftSubTree = generateTreesHelper(left, i-1);
            rightSubTree = generateTreesHelper(i+1, right);
            for (int j = 0; j < leftSubTree.size(); j++) {
                for (int k = 0; k < rightSubTree.size(); k++) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftSubTree.get(j);
                    node.right = rightSubTree.get(k);
                    L.add(node);
                }
            }
        }

        return L;
    }
}
```