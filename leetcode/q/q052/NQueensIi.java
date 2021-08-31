//The n-queens puzzle is the problem of placing n queens on an n x n chessboard 
//such that no two queens attack each other. 
//
// Given an integer n, return the number of distinct solutions to the n-queens p
//uzzle. 
//
// 
// Example 1: 
//
// 
//Input: n = 4
//Output: 2
//Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
//
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 9 
// 
// Related Topics Backtracking 
// 👍 1190 👎 196


package q.q052;

public class NQueensIi {
    public static void main(String[] args) {
        Solution solution = new NQueensIi().new Solution();
        solution.totalNQueens(4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int res = 0;
        int n;
        boolean [] cols;
        boolean [] rows;
        boolean [] ana1;
        boolean [] ana2;
        public int totalNQueens(int n) {
            this.n = n;
            cols = new boolean[n];
            rows = new boolean[n];
            ana1 = new boolean[2*n - 1];
            ana2 = new boolean[2*n - 1];

            bt(0, 0);
            return res;
        }

        void bt(int q, int col){
            if (n == q){
                res += 1;
                return;
            }

            if (n-q > n-col) return;

            for (int j = 0; j < n; j ++){
                if (!rows[j] && !ana1[col + j] && !ana2[col - j + n - 1]) {
                    rows[j] = ana1[col+j] = ana2[col-j + n - 1] = true;
                    q ++;
                    bt(q, col + 1);
                    q --;
                    rows[j] = ana1[col+j] = ana2[col-j + n - 1] = false;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}