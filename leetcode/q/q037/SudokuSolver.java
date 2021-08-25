//Write a program to solve a Sudoku puzzle by filling the empty cells. 
//
// A sudoku solution must satisfy all of the following rules: 
//
// 
// Each of the digits 1-9 must occur exactly once in each row. 
// Each of the digits 1-9 must occur exactly once in each column. 
// Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes
// of the grid. 
// 
//
// The '.' character indicates empty cells. 
//
// 
// Example 1: 
//
// 
//Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5"
//,".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".","."
//,".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".","."
//,"6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"
//],[".",".",".",".","8",".",".","7","9"]]
//Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4
//","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3
//"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],[
//"9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3",
//"4","5","2","8","6","1","7","9"]]
//Explanation: The input board is shown above and the only valid solution is sho
//wn below:
//
//
// 
//
// 
// Constraints: 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] is a digit or '.'. 
// It is guaranteed that the input board has only one solution. 
// 
// Related Topics Array Backtracking Matrix 
// 👍 3587 👎 117


package q.q037;

import java.util.ArrayList;
import java.util.List;

public class SudokuSolver {
    public static void main(String[] args) {
        Solution solution = new SudokuSolver().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        boolean[][] cols = new boolean[9][9];
        boolean[][] rows = new boolean[9][9];
        boolean[][][] blocks = new boolean[3][3][9];
        List<List<Integer>> spaces = new ArrayList<>();
        boolean finished = false;

        public void solveSudoku(char[][] board) {
            for (int i = 0; i < 9; i ++){
                for (int j = 0; j < 9; j ++){
                    if (board[i][j] == '.'){
                        spaces.add(List.of(i, j));
                    } else {
                        int num = board[i][j] - '1';
                        rows[i][num] = cols[j][num] = blocks[i/3][j/3][num] = true;
                    }
                }
            }

            backTrack(board, 0);
        }

        void backTrack(char[][] b, int p){
            if (spaces.size() == p){
                finished = true;
                return;
            }

            var curPos = spaces.get(p);
            int i = curPos.get(0), j = curPos.get(1);

            for (int num = 0; num < 9 && !finished; num++){
                if (!rows[i][num] && !cols[j][num] && !blocks[i/3][j/3][num]){
                    rows[i][num] = cols[j][num] = blocks[i/3][j/3][num] = true;
                    b[i][j] = (char)(num + 1 + '0');
                    backTrack(b, p + 1);
                    rows[i][num] = cols[j][num] = blocks[i/3][j/3][num] = false;

                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}