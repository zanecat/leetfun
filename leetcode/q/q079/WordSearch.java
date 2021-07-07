//Given an m x n grid of characters board and a string word, return true if word
// exists in the grid. 
//
// The word can be constructed from letters of sequentially adjacent cells, wher
//e adjacent cells are horizontally or vertically neighboring. The same letter cel
//l may not be used more than once. 
//
// 
// Example 1: 
//
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "ABCCED"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "SEE"
//Output: true
// 
//
// Example 3: 
//
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "ABCB"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board and word consists of only lowercase and uppercase English letters. 
// 
//
// 
// Follow up: Could you use search pruning to make your solution faster with a l
//arger board? 
// Related Topics Array Backtracking Matrix 
// 👍 6163 👎 252


package q.q079;

public class WordSearch {
    public static void main(String[] args) {
        Solution solution = new WordSearch().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int m = 0;
        int n = 0;
        char [][] b = null;
        char [] chars = null;
        public boolean exist(char[][] b, String word) {


            this.m = b.length;
            this.n = b[0].length;
            this.chars = word.toCharArray();
            this.b = b;
            boolean[][] used = new boolean[m][n];
            for (int i = 0; i < m; i ++){
              for (int j = 0; j < n; j ++){
                  if (b[i][j] == chars[0]){
                      var t = search(i, j, used, 0);
                      if(t) return true;
                  }
              }
            }

            return false;
        }

        boolean search(int i, int j, boolean[][] used, int count){
            if (count == chars.length - 1) return true;
            boolean res = false;

            used[i][j] = true;
            if(i + 1 < m && b[i + 1][j] == chars[count + 1] && !used[i + 1][j]){
                res = res || search(i + 1, j, used, count + 1);
            }

            if(i - 1 >= 0 && b[i - 1][j] == chars[count + 1] && !used[i - 1][j]){
                res = res || search(i - 1, j, used, count + 1);
            }

            if(j + 1 < n && b[i][j + 1] == chars[count + 1] && !used[i][j + 1]){
                res = res || search(i, j + 1, used, count + 1);
            }

            if(j - 1 >= 0 && b[i][j-1] == chars[count + 1] && !used[i][j - 1]){
                res = res || search(i, j - 1, used, count + 1);
            }
            used[i][j] = false;

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}