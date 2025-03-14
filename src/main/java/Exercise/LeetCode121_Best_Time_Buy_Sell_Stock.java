package Exercise;

public class LeetCode121_Best_Time_Buy_Sell_Stock {

    /*

       You are given an array prices where prices[i] is the price of a given stock on the ith day.

       You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

       Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.



       Example 1:

       Input: prices = [7,1,5,3,6,4]
       Output: 5
       Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
       Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
       Example 2:

       Input: prices = [7,6,4,3,1]
       Output: 0
       Explanation: In this case, no transactions are done and the max profit = 0.


       Constraints:

       1 <= prices.length <= 105
       0 <= prices[i] <= 104

     */

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minBuy = Integer.MAX_VALUE;
        int maxStockPrice = 0;
        int maxProfit = 0;
        int left = 0;
        int right = 1;

        while (right < prices.length) {

            if (prices[left] < prices[right]) {
                if (prices[left] < minBuy) {
                    minBuy = prices[left];
                    maxStockPrice = 0;
                }

                if (prices[right] > maxStockPrice) {
                    maxStockPrice = prices[right];
                }

                if ((maxStockPrice - minBuy) > maxProfit) {
                    maxProfit = maxStockPrice - minBuy;
                }
            }

            left++;
            right++;
        }

        return maxProfit;

    }

    public static void main(String[] args) {
        int[] prices = {2,1,2,0,1};
        System.out.println(maxProfit(prices));

    }

}
