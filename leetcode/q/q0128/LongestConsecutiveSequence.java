//Given an unsorted array of integers nums, return the length of the longest con
//secutive elements sequence. 
//
// You must write an algorithm that runs in O(n) time. 
//
// 
// Example 1: 
//
// 
//Input: nums = [100,4,200,1,3,2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Theref
//ore its length is 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,3,7,2,5,8,4,6,0,1]
//Output: 9
// 
//
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// 
// Related Topics Array Hash Table Union Find 
// 👍 6030 👎 278


package q.q0128;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence().new Solution();
        solution.longestConsecutive(new int[] {0,3,7,2,5,8,4,6,0,1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            Map<Integer, Integer> integerMap = new HashMap<>();
            for (int i : nums){
                integerMap.put(i, i);
            }

            int res = -1;

            for (int i: nums){
                int ii = i;
                while (integerMap.containsKey(ii - 1)){
                    ii = ii - 1;
                    ii = integerMap.get(ii);
                }

                integerMap.put(i, ii);
                if (i - ii > res){
                    res = i - ii;
                }
            }

            return res + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}