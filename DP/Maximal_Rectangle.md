## Maximal Rectangle

### Description
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.

### Code 

```java
public class Solution {
    // save the maximum 
    protected static class DPEntry {
        int left;
        int up;
        
        DPEntry() {
            left = 0;
            up = 0;
        }
    }
    public int maximalRectangle(char[][] matrix) {
        // Intuitively, I think it's the 2D dynamic programming problem.
        // I creates a similar way to Unique Path problems. But I am not sure, it will
        // solve the problem. If I am lucky, I will post the idea details to this. 
        
        // General idea: 
        /* Creates a dpMatrix[i][j], dpMatrix[i][j] means at this position, the maximal 
            Rectangle including left part, up part and this point.
            So there are two cases:
                1) if matrix[i][j] == '0', dpMatrix[i][j] = 0
                2) if matrix[i][j] == '1', dpMatrix[i][j] can be 3 cases:
                    (1) the left part + this point
                    (2) the up part + this point
                    (3) the left&up part + this point
                    And we choose the max value during (1)(2)(3)
         */
         
         int m = matrix.length;  
         if (m == 0) {  
             return 0;  
         }  
         int n = matrix[0].length;
         // creates the dpMatrix
         DPEntry[][] dpMatrix = new DPEntry[m+1][n+1];

         int maxArea = 0;
         for (int i=1; i<=m; i++) {
             for (int j=1; j<=n; j++) {
                 if (matrix[i-1][j-1] == '0') {
                     continue;
                 }
                 // case 2, matrix[i][j] == '1': check three directions
                 // 1) check up 
                 dpMatrix[i][j].up = dpMatrix[i-1][j].up + 1;
                 // 2) check left
                 dpMatrix[i][j].left = dpMatrix[i][j-1].left + 1;
                 // 3) check area
                 int minHeight = dpMatrix[i][j].up;
                 int max = 0;
                 for (int k=1; k<=dpMatrix[i][j].left; k++) {
                     minHeight = Math.min(minHeight, dpMatrix[i][j+1-k].up);
                     max = Math.max(max, k * minHeight);
                 }
                 if (maxArea < max) {
                     maxArea = max;
                 }
             }
         }
         return maxArea;
        
    }
}
```