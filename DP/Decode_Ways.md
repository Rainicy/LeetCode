## Decode Ways

### Description
A message containing letters from A-Z is being encoded to numbers using the following mapping:

	'A' -> 1
	'B' -> 2
	...
	'Z' -> 26
	
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.

### Code

```java
public class Solution {
    public int numDecodings(String s) {
        // DP problem and just 1D problem, updates the value from left to right
        /*
        For example: S = '1  2   3'
              dpArray: =  1  2   3  or [case1 d[3]=d[2]+1] 
                     S = '1  2   8' 
              dpArray: =  1  2   2. or [case2 d[3]=d[2]]
                     S = '1  2   0'
              dpArray: =  1  1   1  or [case3 d[3]=--d[2]]
                     S = '3  2   0'
              dpArray: =  1  1   1     [case4 d[3]=d[2]]
        That's to say, we scan the char on s[i], if (s[i-1],s[i]) <= 26, dpArray[i]++, otherwise same.
        Be careful about s[i] == '0', it is a little trick. Need a check before the previous one, i-2
        position, if exits. 
         */
         
        // This algorithm is based on the input is always correct, doesn't check the input string.
        // suppose we won't see "30" or "01" strings in inputs. 
        if ((s == null) || (s.length()==0) || isIllegalInput(s)) {
            return 0;
        }
        
        int[] dpArray = new int[s.length()];
        dpArray[0] = 1;
        for (int i=1; i<s.length(); i++) {
            // if s[i]=0, need check the s[i-2].
            if (s.charAt(i) == '0') {
                // check s[i-2]&s[i-1], if they are the only one decode way
                if(i>=2 && canBeSplited(s.charAt(i-2), s.charAt(i-1))) {    // case 3
                    dpArray[i-1] = dpArray[i-2];
                    dpArray[i] = dpArray[i-1];
                }
                else {  // case 4
                    dpArray[i] = dpArray[i-1];
                }
            }
            else if (canBeSplited(s.charAt(i-1), s.charAt(i))) {    // 
                if (i>=2) {
                    dpArray[i] = dpArray[i-1] + dpArray[i-2];
                }
                else {
                    dpArray[i] = dpArray[i-1] + 1;
                }
            }
            else {
                dpArray[i] = dpArray[i-1];
            }
        }
        
        return dpArray[s.length()-1];
    }
    
    // if [c1,c2] is between 11 to 27, return true, otherwise false
    private boolean canBeSplited(char c1, char c2) {
        if ((c2=='0')&&(c1!='2')) return false; // remove 20 case
        
        if ((c1=='1') || ((c1=='2') && ('0'<=c2) && (c2<='6'))) {
            return true;
        }
        return false;
    }
    
    // check if the input is a illegal input, like "00", "30" together
    private boolean isIllegalInput(String s) {
        if (s.charAt(0)=='0') return true;
        for (int i=1; i<s.length(); i++) {
            if ((s.charAt(i) == '0') && ((s.charAt(i-1)=='0') || s.charAt(i-1)>'2')) {
                return true;
            }
        }
        return false;
    }
}
```