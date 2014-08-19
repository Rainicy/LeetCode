## Triangle

### Description
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
	[
	     [2],
	    [3,4],
	   [6,5,7],
	  [4,1,8,3]
	]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

### Code

```java
public class Solution {
    // ref http://blog.csdn.net/worldwindjp/article/details/18302041
    // In this problem, we will change the original data
    // bottom-up pass the bottom value to the up level.
    // The relation between lower level and higher level:
    // V[i][j] = V[i][j] + min(V[i+1][j], V[i+1][j+1])
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null){
            return 0;
        }
        
        // intialize the dpArray
        for(int i=triangle.size()-2; i>=0; i--) {
            for(int j=0; j<triangle.get(i).size(); j++) {
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
            }
        }
        
        return triangle.get(0).get(0);
    }
}

```