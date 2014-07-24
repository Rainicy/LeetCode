## Climbing Stairs

### Description
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

### Code

```java

public class Solution {
    public int climbStairs(int n) {
        // DP problem + recursion
        // Also use memo-ization to record the calculated number.
        // But we can use bottom-up to iteratively solve the problem. 
        // The n and results S(n) is like:
        // 1) S(1) = 1;
        // 2) S(2) = 2;
        // 3) S(n) = S(n-1) + S(n-2)
        
        if (n <= 2) {
            return n;
        }
        
        // creates the dpArray 
        int[] dpArray = new int[n];
        dpArray[0] = 1;
        dpArray[1] = 2;
        for (int i=2; i<n; i++) {
            dpArray[i] = dpArray[i-1] + dpArray[i-2];
        }
        return dpArray[n-1];
        
    }
}

```