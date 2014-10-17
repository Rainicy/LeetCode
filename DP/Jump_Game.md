## Jump Game

### Description

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.

### Code
```java

public class Solution {
    public boolean canJump(int[] A) {
        // greedy algo
        // ref: http://www.cnblogs.com/remlostime/archive/2012/11/12/2765894.html
        // set previous steps,
        // if steps > 0, update steps = max(--steps, A[i])
        if ((A == null) || (A.length<=1)) {
            return true;
        }
        
        int len = A.length;
        int steps = A[0];
        
        for (int i=1; i<len; i++) {
            if (steps > 0) {
                steps = Math.max(--steps, A[i]);
            }
            else{
                return false;
            }
        }
        return true;
    }
}
```