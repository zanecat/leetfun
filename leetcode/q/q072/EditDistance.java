//Given two strings word1 and word2, return the minimum number of operations req
//uired to convert word1 to word2. 
//
// You have the following three operations permitted on a word: 
//
// 
// Insert a character 
// Delete a character 
// Replace a character 
// 
//
// 
// Example 1: 
//
// 
//Input: word1 = "horse", word2 = "ros"
//Output: 3
//Explanation: 
//horse -> rorse (replace 'h' with 'r')
//rorse -> rose (remove 'r')
//rose -> ros (remove 'e')
// 
//
// Example 2: 
//
// 
//Input: word1 = "intention", word2 = "execution"
//Output: 5
//Explanation: 
//intention -> inention (remove 't')
//inention -> enention (replace 'i' with 'e')
//enention -> exention (replace 'n' with 'x')
//exention -> exection (replace 'n' with 'c')
//exection -> execution (insert 'u')
// 
//
// 
// Constraints: 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 and word2 consist of lowercase English letters. 
// 
// Related Topics String Dynamic Programming 
// 👍 6459 👎 75


package q.q072;

public class EditDistance {
    public static void main(String[] args) {
        Solution solution = new EditDistance().new Solution();
        solution.minDistance("horse", "ros");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {
            String w1 = " " + word1;
            String w2 = " " + word2;

            char [] c1 = w1.toCharArray();
            char [] c2 = w2.toCharArray();

            int m = c1.length;
            int n = c2.length;

            int [][] dp = new int[m][n];

            for (int i = 1; i < m; i ++){
                dp[i][0] = i;
            }

            for (int i = 1; i < n; i ++){
                dp[0][i] = i;
            }

            for (int i = 1; i < m; i++){
                for (int j = 1; j < n; j ++){
                    dp[i][j] = dp[i -1][j-1];
                    if (c1[i] != c2[j]){
                        int temp = Math.min(dp[i - 1][j], dp[i][j - 1]);
                        dp[i][j] = Math.min(dp[i][j], temp) + 1;
                    }
                }
            }

            return dp[m - 1][n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}