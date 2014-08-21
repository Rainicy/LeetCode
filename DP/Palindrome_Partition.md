## Palindrome Partition

### Description
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

	 [
	   ["aa","b"],
	   ["a","a","b"]
	 ]

### Code 
```java
public class Solution {
    // ref: http://blog.csdn.net/u011095253/article/details/9177451
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> list = new ArrayList<String>();
        if ((s==null) || (s.length() == 0)) {
            return result;
        }
        partitionHelper(s, result, list);
        return result;
    }
    
    private void partitionHelper(String s, List<List<String>> result, 
                            List<String> list) {
        // if string is null, add the list to the result. 
        if (s.length() == 0) {
            result.add(new ArrayList<String>(list));
        }
        
        // go through the string, add string[0,i] to list, if it is palindrome.
        // and recursive call the helper function to deal with the rest of string
        for (int i=1; i<=s.length(); i++) {
            String subS = s.substring(0, i);
            if (isPalindrome(subS)) {
                list.add(subS);
                // recursive call
                partitionHelper(s.substring(i), result, list);
                list.remove(list.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while(i<j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
```