//Given an unsorted integer array nums, find the smallest missing positive integ
//er. 
//
// You must implement an algorithm that runs in O(n) time and uses constant extr
//a space. 
//
// 
// Example 1: 
// Input: nums = [1,2,0]
//Output: 3
// Example 2: 
// Input: nums = [3,4,-1,1]
//Output: 2
// Example 3: 
// Input: nums = [7,8,9,11,12]
//Output: 1
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5 * 105 
// -231 <= nums[i] <= 231 - 1 
// 
// Related Topics Array Hash Table 
// 👍 6212 👎 1050


package q.q041_2;

public class FirstMissingPositive {
    public static void main(String[] args) {
        Solution solution = new FirstMissingPositive().new Solution();
        solution.firstMissingPositive(new int[]{1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstMissingPositive(int[] nums) {

            boolean[] order = new boolean[nums.length + 2];
            for (int i : nums) {
                if (i > 0 && i < nums.length + 2) {
                    order[i] = true;
                }
            }

            for (int i = 1; i < order.length; i++) {
                if (!order[i]) return i;
            }

            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}