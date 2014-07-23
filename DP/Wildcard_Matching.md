## Wildcard Matching

### Description
Implement wildcard pattern matching with support for '?' and '*'.
	'?' Matches any single character.
	'*' Matches any sequence of characters (including the empty sequence).

	The matching should cover the entire input string (not partial).

	The function prototype should be:
	bool isMatch(const char *s, const char *p)

	Some examples:
	isMatch("aa","a") → false
	isMatch("aa","aa") → true
	isMatch("aaa","aa") → false
	isMatch("aa", "*") → true
	isMatch("aa", "a*") → true
	isMatch("ab", "?*") → true
	isMatch("aab", "c*a*b") → false

### Code
```java

public class Solution {
    public boolean isMatch(String s, String p) {
        /* s is a normal String and p is a pattern */
        if ((s == null) && (p == null)) {
            return true;
        }
        
        // creates two pointers for s and p. 
        int pointS = 0;
        int pointP = -1; // saving the star position
        
        int i = 0; // index for the s
        int j = 0; // index for the p
        while (i<s.length()) {
            if (j<p.length()) { // because we have p[j] operations here, make sure in the bound.
                // if s[i] == p[j], including p[j] == '?', check the next one
                if ((s.charAt(i) == p.charAt(j)) || (p.charAt(j)=='?')) {
                    i++;
                    j++;
                    continue;
                } 
                // saving the star position to pointP, and the current s position
                if (p.charAt(j) == '*') {
                    pointP = j;
                    pointS = i;
                    j++;    // check if p[j++] == s[i], if yes, means the star stands for 0 char.
                    continue;
                }
            }
            // check if the we get the star before to match current s[i]
            if (pointP >= 0) {
                // keep p curent position until find the p[j]=s[i]
                j = pointP + 1;
                i = ++pointS;   // keep searching the 1,2,3,4... characters. 
                continue;
            }
            return false;
        }
        
        // when it's done in s; maybe there is some left chars in p, 
        // if all the left chars are '*', return true, otherwise false
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }
        return (j == p.length());
    }
}

```
	