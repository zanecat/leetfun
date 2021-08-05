//Given a triangle array, return the minimum path sum from top to bottom. 
//
// For each step, you may move to an adjacent number of the row below. More form
//ally, if you are on index i on the current row, you may move to either index i o
//r index i + 1 on the next row. 
//
// 
// Example 1: 
//
// 
//Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//Output: 11
//Explanation: The triangle looks like:
//   2
//  3 4
// 6 5 7
//4 1 8 3
//The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined abov
//e).
// 
//
// Example 2: 
//
// 
//Input: triangle = [[-10]]
//Output: -10
// 
//
// 
// Constraints: 
//
// 
// 1 <= triangle.length <= 200 
// triangle[0].length == 1 
// triangle[i].length == triangle[i - 1].length + 1 
// -104 <= triangle[i][j] <= 104 
// 
//
// 
//Follow up: Could you do this using only O(n) extra space, where n is the total
// number of rows in the triangle? Related Topics Array Dynamic Programming 
// 👍 3423 👎 338


package q.q120;

import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        Solution solution = new Triangle().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int [][] dp = new int[triangle.size() + 1][triangle.size() + 1];

            for (int i = triangle.size() - 1; i >= 0; i --){
                var list = triangle.get(i);
                for (int j = 0; j < list.size(); j ++){
                    dp[i][j] = list.get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
                }
            }

            return dp[0][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}