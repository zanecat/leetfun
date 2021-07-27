//Given an array of non-negative integers nums, you are initially positioned at 
//the first index of the array. 
//
// Each element in the array represents your maximum jump length at that positio
//n. 
//
// Your goal is to reach the last index in the minimum number of jumps. 
//
// You can assume that you can always reach the last index. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,1,1,4]
//Output: 2
//Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 
//step from index 0 to 1, then 3 steps to the last index.
// 
//
// Example 2: 
//
// 
//Input: nums = [2,3,0,1,4]
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 104 
// 0 <= nums[i] <= 1000 
// 
// Related Topics Array Dynamic Programming Greedy 
// 👍 5049 👎 204


package q.q045;

public class JumpGameIi {
    public static void main(String[] args) {
        Solution solution = new JumpGameIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int jump(int[] nums) {
            int step = 0;
            int end = 0;
            int max = 0;

            for (int i = 0; i < nums.length - 1; i ++){
                max = Math.max(max, i + nums[i]);

                if (i == end){
                    step ++;
                    end = max;
                }
            }

            return step;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}