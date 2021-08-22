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
        solution.coinChange(new int[]{2,5,10,1}, 27);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            if(amount == 0) return 0;
            int [] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            for(int i = 0; i <= amount; i ++){
                if(i % coins[0] == 0) dp[i] = i / coins[0];
            }

            for(int i = 1; i < coins.length; i++){
                for(int j = 1; j <= amount; j ++){
                    if(j >= coins[i]) dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }

            return dp[amount] == amount + 1 ? -1 : dp[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}