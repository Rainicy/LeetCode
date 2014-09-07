## Remove Element

### Description
Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

### Code
```java
public class Solution {
    public int removeElement(int[] A, int elem) {
        
        // two index, one is scan for the A, and another one is 
        // saving the position of current valid index
        int j = 0;
        for (int i=0; i<A.length; i++) {
            if (A[i]!=elem) { //saving the diff elems
                A[j++] = A[i];
            }
        }
        return j;
    }
}
```