//Write an efficient algorithm that searches for a value in an m x n matrix. Thi
//s matrix has the following properties: 
//
// 
// Integers in each row are sorted from left to right. 
// The first integer of each row is greater than the last integer of the previou
//s row. 
// 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//Output: true
// 
//
// Example 2: 
//
// 
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//Output: false
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics Array Binary Search Matrix 
// 👍 3849 👎 212


package q.q074;

public class SearchA2dMatrix {
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrix().new Solution();
        var a = new int[][]{{1,3,4,5},{10,11,16,20}, {23,33,44,55}};
        solution.searchMatrix(a, 11);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int row = findRow(matrix, target);
            int col = findCol(matrix, target, row);

            return matrix[row][col] == target;
        }

        int findRow(int [][] matrix, int target){
            int l = 0, r = matrix.length - 1;

            while (l < r){
                int mid = l + (r - l + 1)/2;

                if (matrix[mid][0] > target) r = mid - 1;
                else l = mid;
            }

            return l;
        }

        int findCol(int [][] matrix, int target, int row){
            int l = 0, r = matrix[0].length - 1;

            while (l < r) {
                int mid = l + (r - l + 1)/2;

                if (matrix[row][mid] > target) r = mid - 1;
                else l = mid;
            }

            return l;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}