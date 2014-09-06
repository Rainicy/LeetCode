## Reverse_Integer

### Description
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.

Have you thought about this?
Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

Throw an exception? Good, but what if throwing an exception is not an option? You would then have to re-design the function (ie, add an extra parameter).

### Code
```java
public class Solution {
    public int reverse(int x) {
        // find the highst bit and save each bit into an array
        List<Integer> digits = new ArrayList<Integer>();
        int flag = 10;
        
        do {
            digits.add(x%flag);
            x = (int)(x/flag);
            
        } while (x != 0);
        
        // Reverse the List 
        int sum = 0;
        flag = 1;
        for (int i=digits.size()-1; i>=0; i--) {
            sum += digits.get(i) * flag;
            flag *= 10;
        }
        
        return sum;
    }
}
```