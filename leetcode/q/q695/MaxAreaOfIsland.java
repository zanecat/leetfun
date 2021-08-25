//You are given an m x n binary matrix grid. An island is a group of 1's (repres
//enting land) connected 4-directionally (horizontal or vertical.) You may assume 
//all four edges of the grid are surrounded by water. 
//
// The area of an island is the number of cells with a value 1 in the island. 
//
// Return the maximum area of an island in grid. If there is no island, return 0
//. 
//
// 
// Example 1: 
//
// 
//Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,
//0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,
//0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]
//]
//Output: 6
//Explanation: The answer is not 11, because the island must be connected 4-dire
//ctionally.
// 
//
// Example 2: 
//
// 
//Input: grid = [[0,0,0,0,0,0,0,0]]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 50 
// grid[i][j] is either 0 or 1. 
// 
// Related Topics Array Depth-First Search Breadth-First Search Union Find Matri
//x 
// 👍 4036 👎 117


package q.q695;

public class MaxAreaOfIsland {
    public static void main(String[] args) {
        Solution solution = new MaxAreaOfIsland().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int m;
        int n;
        public int maxAreaOfIsland(int[][] grid) {
            m = grid.length;
            n = grid[0].length;

            int res = 0;

            for (int i = 0; i < m; i ++){
                for (int j = 0; j < n; j ++){
                    res = Math.max(dfs(grid, i, j), res);
                }
            }

            return res;
        }

        int dfs(int [][] g, int i, int j){
            if (i < 0 || i >= m || j < 0 || j >= n || g[i][j] == 0){
                return 0;
            }

            g[i][j] = 0;
            return 1 + dfs(g, i + 1, j) + dfs(g, i, j + 1) + dfs(g, i - 1, j) + dfs(g, i, j - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}