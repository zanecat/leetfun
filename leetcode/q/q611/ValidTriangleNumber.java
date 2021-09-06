//Given an integer array nums, return the number of triplets chosen from the arr
//ay that can make triangles if we take them as side lengths of a triangle. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,2,3,4]
//Output: 3
//Explanation: Valid combinations are: 
//2,3,4 (using the first 2)
//2,3,4 (using the second 2)
//2,2,3
// 
//
// Example 2: 
//
// 
//Input: nums = [4,2,3,4]
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 1000 
// 
// Related Topics Array Two Pointers Binary Search Greedy Sorting 
// 👍 2025 👎 133


package q.q611;

import java.util.Arrays;

public class ValidTriangleNumber {
    public static void main(String[] args) {
        Solution solution = new ValidTriangleNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int triangleNumber(int[] nums) {
            int res = 0;

            Arrays.sort(nums);
            for (int i = nums.length - 1; i >= 2; i --){
                int j = i - 1;
                int k = 0;

                while (k < j){
                    if (nums[k] + nums[j] > nums[i]){
                        res += j - k;
                        j --;
                    } else {
                        k ++;
                    }
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}