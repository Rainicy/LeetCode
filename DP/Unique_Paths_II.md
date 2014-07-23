## Unique Paths II

### Description

Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

	[
	  [0,0,0],
	  [0,1,0],
	  [0,0,0]
	]

The total number of unique paths is 2.

__Note__: m and n will be at most 100.

### Code

```java

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // The same problem with Unique Path, the updates sequence is the same.
        // When we see the obstacle, we just get the number from up or left,
        // otherwise, sum the dpMatrix value of (up, left).
        
        // To easy calculate, we reconstruct the matrix, scale it to m+1 * n+1;
        // And replaces all 1 to -1, as an obstacle.
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dpMatrix = new int[m+1][n+1];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dpMatrix[i+1][j+1] = -1;
                }
            }
        }
        
        // updates
        if (dpMatrix[1][1] == -1) {
            return 0;
        }
        else {
            dpMatrix[1][1] = 1;
        }
        
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if ((i==1) && (j==1)) {
                    continue;
                }
                if (dpMatrix[i][j] == -1) {
                    continue;
                }
                
                // three other cases
                // no way pass
                if((dpMatrix[i-1][j] == -1) && (dpMatrix[i][j-1] == -1)) {
                    dpMatrix[i][j] = 0;
                }
                // no obstacle
                else if ((dpMatrix[i-1][j] != -1) && (dpMatrix[i][j-1] != -1)) {
                    dpMatrix[i][j] = dpMatrix[i-1][j] + dpMatrix[i][j-1];
                }
                // only one obstacle
                else {
                    dpMatrix[i][j] = (dpMatrix[i-1][j] == -1) ? dpMatrix[i][j-1] : dpMatrix[i-1][j];
                }
            }
        }
        
        return ((dpMatrix[m][n] == -1)? 0: dpMatrix[m][n]);
    }
}

```