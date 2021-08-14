//Given an m x n matrix, return all elements of the matrix in spiral order. 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [1,2,3,6,9,8,7,4,5]
// 
//
// Example 2: 
//
// 
//Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//Output: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics Array Matrix Simulation 
// 👍 4359 👎 691

  
  package q.q054_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix{
      public static void main(String[] args) {
           Solution solution = new SpiralMatrix().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean [][] visited = new boolean[m][n];

        int [][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int i = 0, j = 0;
        List<Integer> res = new LinkedList<>();
        int di = 0;
        while (true){
            if (i >= m || i < 0 || j < 0 || j >= n || visited[i][j]) return res;
            res.add(matrix[i][j]);
            visited[i][j] = true;

            int i1 = direction[di%4][0] + i;
            int j1 = direction[di%4][1] + j;

            if (i1 >= m || i1 < 0 || j1 < 0 || j1 >= n || visited[i1][j1]) {
                di ++;
            }

            i = direction[di%4][0] + i;
            j = direction[di%4][1] + j;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }