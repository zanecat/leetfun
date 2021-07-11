//Given an m x n binary matrix filled with 0's and 1's, find the largest square 
//containing only 1's and return its area. 
//
// 
// Example 1: 
//
// 
//Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1",
//"1"],["1","0","0","1","0"]]
//Output: 4
// 
//
// Example 2: 
//
// 
//Input: matrix = [["0","1"],["1","0"]]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: matrix = [["0"]]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] is '0' or '1'. 
// 
// Related Topics Array Dynamic Programming Matrix 
// 👍 4951 👎 115


package q.q221;

public class MaximalSquare {
    public static void main(String[] args) {
        Solution solution = new MaximalSquare().new Solution();
        solution.maximalSquare(new char[][]{
            new char[]{1,0,1,0},
            new char[]{1,0,1,1},
            new char[]{1,0,1,1},
            new char[]{1,1,1,1},
        });
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalSquare(char[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int res = 0;

            int [][] dp = new int[m][n];

            for (int i = 0; i < m; i ++){
                for (int j = 0; j < n; j ++){
                    if (matrix[i][j] == '1'){
                        int up = 0, left = 0, upLeft = 0;
                        boolean u = j - 1 >= 0, l = i - 1 >= 0;
                        if(u) up = dp[i][j - 1];
                        if(l) left = dp[i - 1][j];
                        if(u && l) upLeft = dp[i-1][j-1];


                        dp[i][j] = Math.min(up, Math.min(upLeft, left)) + 1;
                        res = Math.max(res, dp[i][j]);
                    }
                }
            }

            return res * res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}