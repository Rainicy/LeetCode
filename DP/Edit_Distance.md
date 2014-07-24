## Edit Distance

### Description
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character

### Code 

```java

public class Solution {
    public int minDistance(String word1, String word2) {
        // This is a classic DP problem, which is mentioned during 
        // the public class "Intro to Algorithms" MIT.
        
        // Analysis:
        /* Note, it is a 2D DP problem, which is similar to Longest Common Subsequence problem.
            if we set word1.length = m, word2.length = n;
            and we define dpMatrix[i,j] is the minDistance between word1[0,...,i] and word2[0,...,j].
            Easily we can notice that:
                1) dpMatrix[0,j] = j; // word1 is empty, we need at least j insert ops.
                2) dpMatrix[i,0] = i; // word2 is empty, we need at least i insert ops.
            And we can see two different cases:
                1) if word1[i] == word2[j], dpMatrix[i,j] = dpMatrix[i-1][j-1]
                2) if word1[i] != word2[j], dpMatrix[i,j] = min(dpMatrix[i-1][j-1], dpMatrix[i-1][j], dpMatrix[i][j-1]) + 1
        */
        
        int m = word1.length();
        int n = word2.length();
        // creates dpMatrix[m+1][n+1]
        int[][] dpMatrix = new int[m+1][n+1];
        for (int j=0; j<=n; j++) {
            dpMatrix[0][j] = j;
        }
        for (int i=0; i<=m; i++) {
            dpMatrix[i][0] = i;
        }
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dpMatrix[i][j] = dpMatrix[i-1][j-1];
                }
                else {
                    int min = (dpMatrix[i-1][j-1] < dpMatrix[i-1][j]) ? dpMatrix[i-1][j-1] : dpMatrix[i-1][j];
                    min = (min < dpMatrix[i][j-1]) ? min : dpMatrix[i][j-1];
                    dpMatrix[i][j] = min + 1;
                }
            }
        }
        
        return dpMatrix[m][n];
    }
}

```