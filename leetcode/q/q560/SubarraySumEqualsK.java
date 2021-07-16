//Given an array of integers nums and an integer k, return the total number of c
//ontinuous subarrays whose sum equals to k. 
//
// 
// Example 1: 
// Input: nums = [1,1,1], k = 2
//Output: 2
// Example 2: 
// Input: nums = [1,2,3], k = 3
//Output: 2
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 104 
// -1000 <= nums[i] <= 1000 
// -107 <= k <= 107 
// 
// Related Topics Array Hash Table Prefix Sum 
// 👍 8110 👎 273


package q.q560;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new SubarraySumEqualsK().new Solution();
        solution.subarraySum(new int[]{1}, 0);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int len = nums.length;
            int sum = 0;
            Map<Integer, Integer> sumCount = new HashMap<>();
            int res = 0;
            for (int i = 0; i < len; i ++){
                sum += nums[i];

                res += sumCount.getOrDefault(sum - k, 0);
                sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
            }

            return res + sumCount.getOrDefault(k, 0);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}