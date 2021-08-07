//Given an integer array nums, find the contiguous subarray (containing at least
// one number) which has the largest sum and return its sum. 
//
// A subarray is a contiguous part of an array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//Output: 6
//Explanation: [4,-1,2,1] has the largest sum = 6.
// 
//
// Example 2: 
//
// 
//Input: nums = [1]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: nums = [5,4,-1,7,8]
//Output: 23
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 3 * 104 
// -105 <= nums[i] <= 105 
// 
//
// 
// Follow up: If you have figured out the O(n) solution, try coding another solu
//tion using the divide and conquer approach, which is more subtle. 
// Related Topics Array Divide and Conquer Dynamic Programming 
// 👍 13525 👎 638


package q.q053;

public class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int res = nums[0];
            int n = nums.length;
            int run = nums[0];

            for (int i = 1; i < n; i++) {
                if (run > 0) {
                    run += nums[i];
                } else {
                    run = nums[i];
                }

                res = Math.max(res, run);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}