## Interleaving String

### Description

Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.


### Code

```java
public class Solution {

    // ref: http://www.cnblogs.com/jdflyfly/p/3821266.html
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }


        // create the dpMatrix
        // DP: the recursive formula is:
        // dpMatrix[i][j] = (dpMatrix[i-1][j] && s1[i-1]==s3[i+j-1]) or (dpMatrix[i][j-1] && s2[j-1]==s3[i+j-1])

        boolean[][] dpMatrix = new boolean[s1.length()+1][s2.length()+1];
        // intialize the matrix
        dpMatrix[0][0] = true;
        for (int i=1; i<=s1.length(); i++) {
            dpMatrix[i][0] = ((s1.charAt(i-1) == s3.charAt(i-1)) && dpMatrix[i-1][0]);
        }
        for (int j=1; j<=s2.length(); j++) {
            dpMatrix[0][j] = ((s2.charAt(j-1) == s3.charAt(j-1)) && dpMatrix[0][j-1]);
        }

        for (int i=1; i<=s1.length(); i++) {
            for (int j=1; j<=s2.length(); j++) {
                dpMatrix[i][j] = (((s1.charAt(i-1)==s3.charAt(i+j-1)) && dpMatrix[i-1][j])
                        || ((s2.charAt(j-1)==s3.charAt(i+j-1)) && dpMatrix[i][j-1]));
            }
        }

        return dpMatrix[s1.length()][s2.length()];
    }
}
```
