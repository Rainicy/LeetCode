## Unique Binary Search Trees

### Description 

Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.
	
	1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
	2     1         2                 3

### Code
```java

public class Solution {
    public int numTrees(int n) {
        // This is a DP problem. And the subproblem can be a Catalan Number problem.
        // The recurrence relation is like: http://en.wikipedia.org/wiki/Catalan_number
        // C_0 = 1, for n=0
        // C_n+1 = Sum(C_i*C_n-i), for n>=0
        // C_n = Sum(C_i*C_n-1-i), for n>0

        if (n<=0) {
            return 0;
        }

        // Define the dpArray
        int[] dpArray = new int[n+1];
        dpArray[0] = 1;

        for (int i=1; i<=n; i++) {
            for (int j=0; j<i; j++) {
                dpArray[i] += dpArray[j] * dpArray[i-1-j];
            }
        }
        return dpArray[n];
    }
}

```