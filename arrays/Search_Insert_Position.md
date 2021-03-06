## Search Insert Position

### Description

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0

### Code
```java
public class Solution {
    public int searchInsert(int[] A, int target) {
        // binary search algorithm, no recursive
        
        int start = 0;
        int end = A.length-1;
        
        while (start < end) {
            int mid = (start + end) / 2;
            if (target == A[mid]) {
                return mid;
            }
            else if (target < A[mid]) { // search left
                end = mid - 1; 
            }
            else {
                start = mid + 1;
            }
        }
        if (target > A[start]) {
            return start + 1;
        }
        else {
            return start;
        }
    }
}
```