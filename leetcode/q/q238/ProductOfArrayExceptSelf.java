//Given an integer array nums, return an array answer such that answer[i] is equ
//al to the product of all the elements of nums except nums[i]. 
//
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit 
//integer. 
//
// You must write an algorithm that runs in O(n) time and without using the divi
//sion operation. 
//
// 
// Example 1: 
// Input: nums = [1,2,3,4]
//Output: [24,12,8,6]
// Example 2: 
// Input: nums = [-1,1,0,-3,3]
//Output: [0,0,9,0,0]
// 
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 105 
// -30 <= nums[i] <= 30 
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit 
//integer. 
// 
//
// 
// Follow up: Can you solve the problem in O(1) extra space complexity? (The out
//put array does not count as extra space for space complexity analysis.) 
// Related Topics Array Prefix Sum 
// 👍 8032 👎 584


package q.q238;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        Solution solution = new ProductOfArrayExceptSelf().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int [] proL = new int[nums.length];
            int [] proR = new int[nums.length];
            proL[0] = nums[0];
            proR[nums.length - 1] = nums[nums.length - 1];
            for (int i = 1; i < nums.length; i ++){
                proL[i] = nums[i] * proL[i - 1];
            }

            for (int i = nums.length - 2;i >= 0; i --){
                proR[i] = nums[i] * proR[i + 1];
            }

            int [] res = new int[nums.length];
            for (int i = 1; i < nums.length - 1; i ++){
                res[i] = proL[i - 1] * proR[i + 1];
            }
            res[0] = proR[1];
            res[nums.length - 1] = proL[nums.length - 2];

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}