//Given an m x n matrix mat, return an array of all the elements of the array in
// a diagonal order. 
//
// 
// Example 1: 
//
// 
//Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [1,2,4,7,5,3,6,8,9]
// 
//
// Example 2: 
//
// 
//Input: mat = [[1,2],[3,4]]
//Output: [1,2,3,4]
// 
//
// 
// Constraints: 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 104 
// 1 <= m * n <= 104 
// -105 <= mat[i][j] <= 105 
// 
// Related Topics Array Matrix Simulation 
// 👍 1496 👎 442


package q.q498;

public class DiagonalTraverse {
    public static void main(String[] args) {
        Solution solution = new DiagonalTraverse().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findDiagonalOrder(int[][] mat) {
            boolean d = true;

            int [][] dir = new int[][]{{-1, 1}, {1, -1}};

            int m = mat.length, n = mat[0].length;

            int [] res = new int[m * n];
            int size = m * n;
            int x = 0, y = 0;
            for (int i = 0; i < size ; i++){
                res[i] = mat[x][y];

                int nx = x, ny = y;
                if (d){
                     nx = nx + dir[0][0];
                     ny = ny + dir[0][1];
                } else {
                    nx = nx + dir[1][0];
                    ny = ny + dir[1][1];
                }

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    d = !d;
                    if (nx < 0 && ny == n){
                        nx = 1;
                        ny = n - 1;
                    }

                    if (ny < 0 && nx == m){
                        ny = 1;
                        nx = m - 1;
                    }

                    if (nx < 0) {
                        nx = 0;
                    }
                    if (nx == m) {
                        nx = m - 1;
                        ny += 2;
                    }
                    if (ny < 0) {
                        ny = 0;
                    }
                    if (ny == n) {
                        ny = n - 1;
                        nx += 2;
                    }

                }

                x = nx;
                y = ny;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}