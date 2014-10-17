## Jump Game II

### Description
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

### Code
```java
public class Solution {
    // ref: http://blog.csdn.net/loverooney/article/details/38455475
    public int jump(int[] A) {
        if ((A == null) || (A.length == 1)) {
            return 0;
        }
        
        int len = A.length;
        int count = 0; // current number of jumps
        int lastDistant = 0; // last time the longest distance can reach
        int currDistant = 0; // current the longest distance can reach
        for (int i=0; i<len; i++) {
            if (currDistant < i) {
                return -1; // cannot reach
            }
            if (lastDistant < i) {
                // we need jump, count++, e.g last we didn't reach i position
                lastDistant = currDistant;
                count++;
            }
            // update currDistant
            currDistant = Math.max(currDistant, A[i]+i);
        }
        
        return count;
    }
}
```