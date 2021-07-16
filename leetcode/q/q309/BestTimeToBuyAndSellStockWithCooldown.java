//You are given an array prices where prices[i] is the price of a given stock on
// the ith day. 
//
// Find the maximum profit you can achieve. You may complete as many transaction
//s as you like (i.e., buy one and sell one share of the stock multiple times) wit
//h the following restrictions: 
//
// 
// After you sell your stock, you cannot buy stock on the next day (i.e., cooldo
//wn one day). 
// 
//
// Note: You may not engage in multiple transactions simultaneously (i.e., you m
//ust sell the stock before you buy again). 
//
// 
// Example 1: 
//
// 
//Input: prices = [1,2,3,0,2]
//Output: 3
//Explanation: transactions = [buy, sell, cooldown, buy, sell]
// 
//
// Example 2: 
//
// 
//Input: prices = [1]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= prices.length <= 5000 
// 0 <= prices[i] <= 1000 
// 
// Related Topics Array Dynamic Programming 
// 👍 3905 👎 129


package q.q309;

public class BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockWithCooldown().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int [] dpbuy = new int[n];
            int [] dpsell = new int[n];
            int [] dpno = new int[n];

            dpbuy[0] = -1 * prices[0];
            dpsell[0] = 0;
            dpno[0] = 0;

            for (int i = 1; i < n; i ++){
                dpbuy[i] = Math.max(dpno[i - 1] - prices[i], dpbuy[i - 1]);
                dpno[i] = Math.max(dpno[i - 1], dpsell[i - 1]);
                dpsell[i] = dpbuy[i - 1] + prices[i];
            }

            return Math.max(dpno[n - 1], dpsell[n - 1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}