## Best Time to Buy and Sell Stock

### Description
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

### Code
```java
public class Solution {
    // find the maximum (prices[j]-prices[i]), where i<j.
    // Save the min value during the loop
    public int maxProfit(int[] prices) {
        if (prices.length < 2) { // only one price, cannot finish buy and sell
            return 0;
        }
        
        int minPriceIndex = 0;
        int maxProfit = 0;
        for (int i=1; i<prices.length; i++) {
            int profit = prices[i] - prices[minPriceIndex];
            if (profit > maxProfit) {
                maxProfit = profit;
            }
            if (profit < 0) {
                minPriceIndex = i;
            }
        }
        return maxProfit;
    }
}
```