//You are given an integer array coins representing coins of different denominat
//ions and an integer amount representing a total amount of money. 
//
// Return the fewest number of coins that you need to make up that amount. If th
//at amount of money cannot be made up by any combination of the coins, return -1.
// 
//
// You may assume that you have an infinite number of each kind of coin. 
//
// 
// Example 1: 
//
// 
//Input: coins = [1,2,5], amount = 11
//Output: 3
//Explanation: 11 = 5 + 5 + 1
// 
//
// Example 2: 
//
// 
//Input: coins = [2], amount = 3
//Output: -1
// 
//
// Example 3: 
//
// 
//Input: coins = [1], amount = 0
//Output: 0
// 
//
// Example 4: 
//
// 
//Input: coins = [1], amount = 1
//Output: 1
// 
//
// Example 5: 
//
// 
//Input: coins = [1], amount = 2
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics Array Dynamic Programming Breadth-First Search 
// 👍 7580 👎 207


package q.q322;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        solution.coinChange(new int[]{1,2,5}, 11);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int max = amount + 1;
            if(amount == 0) return 0;
            int [] dp = new int[amount + 1];
            int start = max;
            Arrays.fill(dp, max);
            for (int i : coins) {
                if(i <= amount){
                    dp[i] = 1;
                    start = Math.min(i, start);
                }
            }

            for(int i = start + 1; i < amount + 1; i ++){
                for(int c: coins){
                    if(i > c) {
                        dp[i] = Math.min(dp[i], dp[i - c] + 1);
                    }
                }
            }

            return dp[amount] == max ? -1 : dp[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}