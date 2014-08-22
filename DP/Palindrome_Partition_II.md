## Palindrome Partition II

### Description

Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.


```java
public class Solution {
    // ref: 1) http://blog.csdn.net/worldwindjp/article/details/22066307
    //      2) http://blog.csdn.net/u011095253/article/details/9177451
    public int minCut(String s) {
        if ((s==null) || (s.length()==0)) {
            return 0;
        }
        
        int len = s.length();
        // dpMatrix[i][j] string[i,j] is a palindrome or not.
        boolean[][] dpMatrix = new boolean[len][len];
        // cuts[i] saves the minimum cuts from string[i, end];
        // cuts[i] = min(len-i, cuts[j+1]+1), where i<j<len 
        int[] cuts = new int[len+1];
        
        // two dp ways: dpMatrix, cuts.
        for (int i=len-1; i>=0; i--) {
            cuts[i] = len-i;
            for (int j=i; j<len; j++) {
                // if even or odd length string is a palindrome or not, if yes,
                // go to the function.
                if ((s.charAt(i) == s.charAt(j)) && ((j-i<2) || dpMatrix[i+1][j-1])) {
                    dpMatrix[i][j] = true;
                    cuts[i] = Math.min(cuts[i], cuts[j+1]+1);
                }
            }
        }
        
        return cuts[0] - 1;
    }
}
```