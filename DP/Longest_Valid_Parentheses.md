## Longest Valid Parentheses

### Description
	Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

	For "(()", the longest valid parentheses substring is "()", which has length = 2.

	Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.

### Code

```java

public class Solution {
    public int longestValidParentheses(String s) {
        // Uses DP to solve it. 
        /* Creates a DP array[s.length()] to store the longest matched pair.
            For example: 
                        ( ) ( ( ) ) 's DP array looks as following:
                       [6,0,4,2,0,0] OR 
                        ( ) ) ( ( ) ) 's DP array is:
                       [2,0,0,4,2,0,0] OR
                        ( ) ( ( ) 's DP array is:
                       [2,0,0,2,0]
                        
            Idea: Scan the s from the tail to the head.
         */

        if (s == null) {
            return 0;
        }
        
        int maxMatched = 0;
        int[] dpArray = new int[s.length()];
        // update the dpArray
        // updates the dp only when you meet '('.
        for (int i=s.length()-2; i>=0; i--) {
            // updates
            if (s.charAt(i) == '(') {
                int j = i+1 + dpArray[i+1]; // find the nearest location j, skip the matched pairs.
                // good to find the matched 
                if (j < s.length() && s.charAt(j) == ')') {
                    dpArray[i] = dpArray[i+1] + 2;
                    
                    // j+1 need to be added to dpArray[i]
                    if (j+1 < s.length()) {
                        dpArray[i] += dpArray[j+1];
                    }
                }
                // else continue.
                if (maxMatched < dpArray[i]) {
                    maxMatched = dpArray[i];
                }
            }
        }
        return maxMatched;
        
    }
}

```