## Maximum Subarray

### Description

	Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

	For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
	the contiguous subarray [4,−1,2,1] has the largest sum = 6.

	More practice:
	If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.


### Code

```java

public class Solution {
    public int maxSubArray(int[] A) {
        // Uses the DP
        /*
         Creates a dpArray[A.length] to store the maximum value of itself, or sum from previous dp value. 
         Go through the A from 0 to A.length
         For example: -2, 1, -3, 4, -1, 2, 1, -5, 4 's dpArray is like:
                      -2, 1, -2, 4,  3, 5, 6,  1, 5. So the result is 6.
         */
         
        // initial dpArray with -inf
        int[] dpArray = new int[A.length];
        for (int i=0; i<A.length; i++) {
            dpArray[i] = Integer.MIN_VALUE;
        }
        
        int max = A[0];
        // updates the dpArray
        dpArray[0] = A[0];
        for (int i=1; i<A.length; i++) {
            // sum with previous dp value > A[i], dpArray[i] = sum(A[i]+dp[i-1])
            if ((A[i]+dpArray[i-1]) > A[i]) {
                dpArray[i] = A[i] + dpArray[i-1];
            }
            else {
                dpArray[i] = A[i];
            }
            
            if (max < dpArray[i]) {
                max = dpArray[i];
            }
        }
        
        return max;
    }
}

```