//Given an integer n, return the least number of perfect square numbers that sum
// to n. 
//
// A perfect square is an integer that is the square of an integer; in other wor
//ds, it is the product of some integer with itself. For example, 1, 4, 9, and 16 
//are perfect squares while 3 and 11 are not. 
//
// 
// Example 1: 
//
// 
//Input: n = 12
//Output: 3
//Explanation: 12 = 4 + 4 + 4.
// 
//
// Example 2: 
//
// 
//Input: n = 13
//Output: 2
//Explanation: 13 = 4 + 9.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 104 
// 
// Related Topics Math Dynamic Programming Breadth-First Search 
// 👍 4748 👎 247


package q.q279;

public class PerfectSquares {
    public static void main(String[] args) {
        Solution solution = new PerfectSquares().new Solution();
        solution.numSquares(12);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSquares(int n) {
            int [] dp = new int[n + 1];

            for (int i = 0; i < n + 1; i ++){
                dp[i] = i;
                for (int j = 0; j * j <= i; j ++){
                    dp[i] = Math.min(dp[i - j*j] + 1, dp[i]);
                }
            }

            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}