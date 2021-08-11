//Given an integer array nums, you need to find one continuous subarray that if 
//you only sort this subarray in ascending order, then the whole array will be sor
//ted in ascending order. 
//
// Return the shortest such subarray and output its length. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,6,4,8,10,9,15]
//Output: 5
//Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the 
//whole array sorted in ascending order.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,4]
//Output: 0
// 
//
// Example 3: 
//
// 
//Input: nums = [1]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 104 
// -105 <= nums[i] <= 105 
// 
//
// 
//Follow up: Can you solve it in O(n) time complexity? Related Topics Array Two 
//Pointers Stack Greedy Sorting Monotonic Stack 
// 👍 4238 👎 189


package q.q581;

public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        Solution solution = new ShortestUnsortedContinuousSubarray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            int n = nums.length;
            int max = Integer.MIN_VALUE, l = -1;
            int min = Integer.MAX_VALUE, r = -1;

            for (int i = 0; i < n; i ++){
                if (max > nums[i]) r = i;
                else max = nums[i];

                if (min < nums[n - 1 - i]) l = n - 1 - i;
                else min = nums[n - 1- i];
            }

            if (r == -1) return 0;
            else return r - l + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}