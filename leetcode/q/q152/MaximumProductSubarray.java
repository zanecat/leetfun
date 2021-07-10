//Given an integer array nums, find a contiguous non-empty subarray within the a
//rray that has the largest product, and return the product. 
//
// It is guaranteed that the answer will fit in a 32-bit integer. 
//
// A subarray is a contiguous subsequence of the array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,-2,4]
//Output: 6
//Explanation: [2,3] has the largest product 6.
// 
//
// Example 2: 
//
// 
//Input: nums = [-2,0,-1]
//Output: 0
//Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 104 
// -10 <= nums[i] <= 10 
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit 
//integer. 
// 
// Related Topics Array Dynamic Programming 
// 👍 7407 👎 239


package q.q152;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumProductSubarray().new Solution();
        solution.maxProduct(new int[]{2,3,-2,4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            int res = nums[0];

            int max = nums[0];
            int min = nums[0];

            for (int i = 1; i < nums.length ; i ++){
                int ii = nums[i];

                int ma = max * ii;
                int mi = min * ii;

                if (ma > mi){
                    max = Math.max(ii, ma);
                    min = Math.min(ii, mi);
                } else {
                    max = Math.max(ii, mi);
                    min = Math.min(ii, ma);
                }
                res = Math.max(max, res);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}