## Best Time to Buy and Sell Stock III

### Description
Say you have an array for which the i-th element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
### Code

```java
public class Solution {
    // Same questions with I, the maximum two profits should be from [0,i] and [i+1, n].
    public int maxProfit(int[] prices) {
        if(prices.length < 2) {
            return 0;
        }
        
        // using dpArray to save the max profit for i;
        int[] dpArray = new int[prices.length];
        int minPrice = prices[0];
        for (int i=1; i<prices.length; i++) {
            dpArray[i] = Math.max(dpArray[i-1], prices[i]-minPrice);
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            }
        }
        // now go through from tail to head, and save the MaxProfits, one from [0~i],
        // another one is from [i+1 ~ n]
        int maxPrice = prices[prices.length-1];
        int[] dpArrayReverse = new int[prices.length];
        dpArrayReverse[prices.length-1] = 0;
        int finalMax = 0;
        for (int i=prices.length-2; i>=0; i--) {
            dpArrayReverse[i] = Math.max(dpArrayReverse[i+1], maxPrice-prices[i]);
            if (maxPrice < prices[i]) {
                maxPrice = prices[i];
            }
            finalMax = Math.max(finalMax, dpArray[i] + dpArrayReverse[i]);
        }
        
        return finalMax;
    }
}

```