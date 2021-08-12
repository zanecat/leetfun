//Given an m x n matrix board containing 'X' and 'O', capture all regions that a
//re 4-directionally surrounded by 'X'. 
//
// A region is captured by flipping all 'O's into 'X's in that surrounded region
//. 
//
// 
// Example 1: 
//
// 
//Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O"
//,"X","X"]]
//Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X
//"]]
//Explanation: Surrounded regions should not be on the border, which means that 
//any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not o
//n the border and it is not connected to an 'O' on the border will be flipped to 
//'X'. Two cells are connected if they are adjacent cells connected horizontally o
//r vertically.
// 
//
// Example 2: 
//
// 
//Input: board = [["X"]]
//Output: [["X"]]
// 
//
// 
// Constraints: 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] is 'X' or 'O'. 
// 
// Related Topics Array Depth-First Search Breadth-First Search Union Find Matri
//x 
// 👍 3233 👎 849


package q.q130;

public class SurroundedRegions {
    public static void main(String[] args) {
        Solution solution = new SurroundedRegions().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        char[][] board;
        boolean[][] x;
        boolean[][] visited;
        int m, n;

        public void solve(char[][] board) {
            this.board = board;

            m = board.length;
            n = board[0].length;
            x = new boolean[m][n];
            visited = new boolean[m][n];

            for (int i = 0; i < m; i ++){
                for (int j = 0; j < n;j ++) {
                    if(i == 0 || j == 0 || i == m - 1 || j == n - 1){
                        go(i, j, 0, 0);
                    }
                }
            }

            for (int i = 0; i < m; i ++){
                for (int j = 0; j < n;j ++){
                    if (board[i][j] == 'O') {
                        if(!x[i][j]) {
                            board[i][j] = 'X';
                        }
                    }
                }
            }
        }

        void go(int i, int j, int h, int w){
            int newi = i + h;
            int newj = j + w;

            if (newi >= 0 && newi < m && newj < n && newj>= 0){
                if (!visited[newi][newj]){
                    if (board[newi][newj] == 'O'){
                        x[newi][newj] = true;
                        visited[newi][newj] = true;
                        go(newi, newj, 1, 0);
                        go(newi, newj, -1, 0);
                        go(newi, newj, 0, 1);
                        go(newi, newj, 0, -1);
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}