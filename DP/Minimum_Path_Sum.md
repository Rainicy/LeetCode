## Minimum Path Sum

### Description
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

__Note:__ You can only move either down or right at any point in time.

### Code
```java

public class Solution {
    public int minPathSum(int[][] grid) {
        // DP 
        // Similar to Unique Paths
        // This time we go through the path, we choose the smaller way to update the dp values
        
        // This time, dont scale the grid, use the original grid as dpArray
        
        int m = grid.length;
        int n = grid[0].length;
        // First, update the first row and first column. 
        for (int j=1; j<n; j++) {
            grid[0][j] += grid[0][j-1];
        }
        for (int i=1; i<m; i++) {
            grid[i][0] += grid[i-1][0];
        }
        
        // updates the dp values
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                // get the smaller value from up or left
                int small = (grid[i-1][j] < grid[i][j-1]) ? grid[i-1][j] : grid[i][j-1];
                grid[i][j] += small;
            }
        }
        
        return grid[m-1][n-1];
    }
}

```