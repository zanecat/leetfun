//Given a non-empty integer array of size n, find the minimum number of moves re
//quired to make all array elements equal, where a move is incrementing n - 1 elem
//ents by 1. 
//
// Example:
// 
//Input:
//[1,2,3]
//
//Output:
//3
//
//Explanation:
//Only three moves are needed (remember each move increments two elements):
//
//[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
// 
// Related Topics 数学 
// 👍 150 👎 0

/*
Math!!!!

n-1 elements increment 1 => 1 element decrement 1
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 */


package q.q453;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElements {
  public static void main(String[] args) {
    Solution solution = new MinimumMovesToEqualArrayElements().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int minMoves(int[] nums) {
      int moves = 0, min = Integer.MAX_VALUE;
      for (int i = 0; i < nums.length; i++) {
        moves += nums[i];
        min = Math.min(min, nums[i]);
      }
      return moves - min * nums.length;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}