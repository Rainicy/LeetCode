## Single Number II

### Description
Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

### Code
```java
public class Solution {
    public int singleNumber(int[] A) {
        
        // sort A
        Arrays.sort(A);
        
        for (int i=0; i<A.length-2; i+=3) {
            if ((A[i] == A[i+1]) && (A[i] == A[i+2])) {
                continue;
            }
            else {
                return A[i];
            }
        }
        return A[A.length-1];
    }
}
```