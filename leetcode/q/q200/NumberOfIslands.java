//Given an m x n 2D binary grid grid which represents a map of '1's (land) and '
//0's (water), return the number of islands. 
//
// An island is surrounded by water and is formed by connecting adjacent lands h
//orizontally or vertically. You may assume all four edges of the grid are all sur
//rounded by water. 
//
// 
// Example 1: 
//
// 
//Input: grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] is '0' or '1'. 
// 
// Related Topics Array Depth-First Search Breadth-First Search Union Find Matri
//x 
// 👍 9688 👎 263


package q.q200;

public class NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
        solution.numIslands(new char[][]{
            {'1', '1', '0', '0','0'},
            {'1', '1', '0', '0','0'},
            {'0', '0', '1', '0','0'},
            {'0', '0', '0', '1','1'},
        });
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[][] visited;
        public int numIslands(char[][] grid) {
            int m = grid.length, n = grid[0].length;
            visited = new boolean[m][n];
            int res = 0;

            for (int i = 0; i < m; i ++){
                for (int j = 0; j < n; j++){
                    if (grid[i][j] == '0' || visited[i][j]){
                        continue;
                    }

                    if (grid[i][j] == '1' && !visited[i][j]) res++;
                    check(grid, i, j);

                }
            }

            return res;
        }

        void check(char[][] grid, int i, int j){
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
                return;
            }

            if (grid[i][j] == '1' && !visited[i][j]){
                visited[i][j] = true;
                check(grid, i + 1, j);
                check(grid, i, j - 1);
                check(grid, i - 1, j);
                check(grid, i, j+1);
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}