//The n-queens puzzle is the problem of placing n queens on an n×n chessboard su
//ch that no two queens attack each other. 
//
// 
//
// Given an integer n, return all distinct solutions to the n-queens puzzle. 
//
// Each solution contains a distinct board configuration of the n-queens' placem
//ent, where 'Q' and '.' both indicate a queen and an empty space respectively. 
//
// Example: 
//
// 
//Input: 4
//Output: [
// [".Q..",  // Solution 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // Solution 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//Explanation: There exist two distinct solutions to the 4-queens puzzle as show
//n above.
// 
// Related Topics 回溯算法 
// 👍 630 👎 0


package q.q051;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
  public static void main(String[] args) {
    Solution solution = new NQueens().new Solution();
    System.out.println(solution.solveNQueens(3));
  }

  //leetcode submit region begin(Prohibit modification and deletion)

  //very slow, need to record more detail like column and diagonals
  class Solution {
    public List<List<String>> solveNQueens(int n) {
      List<List<String>> result = new ArrayList<>();
      if(n == 0){
        return result;
      }

      char[][] matrix = new char[n][n];

      for (int i = 0; i < n; i ++){
        for (char [] chars: matrix){
          chars[i] = '.';
        }
      }

      backtrack(matrix, 0, 0, result, 0);

      return result;

    }

    void backtrack(char[][] matrix, int row, int col, List<List<String>> result, int nq){

      if(nq == matrix.length){
        List<String> cur = new ArrayList<>();
        for (char [] chars: matrix){
          cur.add(String.valueOf(chars));
        }
        result.add(cur);
        return;
      }

//      if(row == matrix.length || col == matrix.length) return;

      for (int i = row; i < matrix.length; i ++){
        for (int j = 0; j < matrix.length; j ++){


          if(isValid(matrix, i, j)){
            matrix[i][j] = 'Q';
            backtrack(matrix, i + 1, 0, result, nq + 1);
          }

          matrix[i][j] = '.';
        }
      }
    }

    boolean isValid(char[][] matrix, int x, int y){

      int len = matrix.length;
      for (int i = 0; i < len; i ++){
        if(i != y &&matrix[x][i] == 'Q') return false;
        if(i != x &&matrix[i][y] == 'Q') return false;
        if(i > 0){
          if(x - i >= 0) {
            if(y - i >= 0 && matrix[x-i][y-i] == 'Q') return false;
            if(y + i < len && matrix[x-i][y+i] == 'Q') return false;
          }

          if(x + i < len) {
            if(y - i >= 0 && matrix[x + i][y-i] == 'Q') return false;
            if(y + i < len && matrix[x + i][y+i] == 'Q') return false;
          }
        }
      }

      return true;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}