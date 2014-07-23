# Regular Expression Matching

### Description
Implement regular expression matching with support for '.' and '*'.

	'.' Matches any single character.
	'*' Matches zero or more of the preceding element.

	The matching should cover the entire input string (not partial).

	The function prototype should be:
	bool isMatch(const char *s, const char *p)

	Some examples:
	isMatch("aa","a") → false
	isMatch("aa","aa") → true
	isMatch("aaa","aa") → false
	isMatch("aa", "a*") → true
	isMatch("aa", ".*") → true
	isMatch("ab", ".*") → true
	isMatch("aab", "c*a*b") → true

### Code

```java
public class Solution {
    public boolean isMatch(String s, String p) {
        /* s is a normal String and p is a pattern */
        if ((s == null) && (p == null)) {
            return true;
        }
        
        return match(s, p, 0, 0);
    }
    
    private boolean match(String s, String p, int i, int j) {
        if (j==p.length()) {
            return (i==s.length());
        }
        char c2 = p.charAt(j);
        // if p[j] is the last char
        if (j==p.length()-1) {
            // s still has char
            if ((i!=s.length()) && ((c2==s.charAt(i)) || c2 == '.')) {
                return match(s, p, i+1, j+1);
            }
            else {
                return false;
            }
        }
        // if p[j] is not the last char, we need check if the next char is '*' or not
        else {
            // if next char is not '*', it's the same with above situation
            if (p.charAt(j+1) != '*') {
                if ((i!=s.length()) && ((c2==s.charAt(i)) || c2 == '.')) {
                    return match(s, p, i+1, j+1);
                }
                else {
                    return false;
                }
            }
            // if next char is '*', we need compare more chars in s until we cannot found more.
            // example: (s: "aaab", p:"a*b") or (s:"aaab", p:"c*a*b")
            else {
                while ((i!=s.length()) && ((c2==s.charAt(i)) || c2 == '.')) {
                    if (match(s, p, i, j+2)) {
                        return true;
                    }
                    i++;
                }
                return (match(s,p,i,j+2));
            }
        }
    }
}

```