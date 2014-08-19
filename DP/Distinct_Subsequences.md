## Distinct Subsequences

### Description
Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.

### Code

```java
public class Solution {
    // Ref: http://blog.csdn.net/worldwindjp/article/details/19770281
    
    // The Dp problem, we create a dpMatrix[m][n], m = S.length, n = T.length. 
    // The current problem dpMatrix[m][n] can be splited by two cases:
    // 1) Current letter S[m] == T[n], then we can keep the letter in S[m] or omit it. So there 
    //          are total two ways to get current status:
    //          dpMatrix[i][j] = dpMatrix[i-1][j-1](keep) + dpMatrix[i-1][j](omit)
    // 2) Current letter S[m] != T[n], then we can only omit it. So there is only one way to get current status:
    //          dpMatrix[i][j] = dpMatrix[i-1][j](omit)
    // 0) Initial Status:
    //      dpMatrix[0][0] = 1
    //      dpMatrix[i][0] = 1 //delete each one letter to null, there is 1 way
    public int numDistinct(String S, String T) {
        if (S.length() < T.length()) {
            return 0;
        }
        
        // initial dpMatrix
        int[][] dpMatrix = new int[S.length()+1][T.length()+1];
        for (int i=0; i<= S.length(); i++) {
            dpMatrix[i][0] = 1;
        }
        
        // DP
        for (int i=1; i<=S.length(); i++) {
            for (int j=1; j<=T.length(); j++) {
                if (S.charAt(i-1) == T.charAt(j-1)) {   // Case 1
                    dpMatrix[i][j] = dpMatrix[i-1][j-1] + dpMatrix[i-1][j]; 
                }
                else {      // Case 2
                    dpMatrix[i][j] = dpMatrix[i-1][j];
                }
            }
        }
        return dpMatrix[S.length()][T.length()];
        
    }
}
```