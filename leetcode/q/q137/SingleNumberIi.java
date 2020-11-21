//Given a non-empty array of integers, every element appears three times except 
//for one, which appears exactly once. Find that single one. 
//
// Note: 
//
// Your algorithm should have a linear runtime complexity. Could you implement i
//t without using extra memory? 
//
// Example 1: 
//
// 
//Input: [2,2,3,2]
//Output: 3
// 
//
// Example 2: 
//
// 
//Input: [0,1,0,1,0,1,99]
//Output: 99 
// Related Topics Bit Manipulation 
// 👍 2073 👎 373


package q.q137;

public class SingleNumberIi {
  public static void main(String[] args) {
    Solution solution = new SingleNumberIi().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int singleNumber(int[] nums) {
        int once =0, twice = 0;

        for (int x: nums){
          once = ~twice & (once ^ x);
          twice = ~once & (twice ^ x);
        }

        return once;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}