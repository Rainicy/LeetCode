## Roman to Integer

### Description
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

### Code
```java
public class Solution {
    public int romanToInt(String s) {
        
        // The roman number is encoded by 
        // 1) plus(smaller is on the right position to bigger bit)[IX: 10-1] or 
        // 2) minus (smaller is on the left position to the bigger bit)[XI: 10+1]
        
        // scan s from left to right. 
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int sum = charToInt(s.charAt(s.length()-1));
        for(int i=s.length()-2; i>=0; i--) {
            int pos = charToInt(s.charAt(i+1));
            int cur = charToInt(s.charAt(i));
            if (pos<=cur) {
                sum += cur;
            }
            else {
                sum -= cur;
            }
        }
        return sum;
    }
    
    private int charToInt(char c) {
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;  
        }
    }
}
```