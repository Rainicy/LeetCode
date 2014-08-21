## Best Time to Buy and Sell Stock II 

### Description
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

### Code

```java
public class Solution {
    // go through the prices, if we just sell the stock before the 
    // price is going down, and didn't buy the stock until the price is going up.
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        
        int maxProfit = 0;
        
        for (int i=1; i<prices.length; i++) {
            int profit = prices[i] - prices[i-1];
            if (profit > 0) {
                maxProfit += profit;
            }
        }
        return maxProfit;
    }
}
```