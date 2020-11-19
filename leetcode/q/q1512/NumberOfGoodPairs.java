//Given an array of integers nums. 
//
// A pair (i,j) is called good if nums[i] == nums[j] and i < j. 
//
// Return the number of good pairs. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,1,1,3]
//Output: 4
//Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,1,1,1]
//Output: 6
//Explanation: Each pair in the array are good.
// 
//
// Example 3: 
//
// 
//Input: nums = [1,2,3]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 100 
// 1 <= nums[i] <= 100 
// Related Topics Array Hash Table Math 
// 👍 656 👎 58


package q.q1512;

import java.util.Arrays;

public class NumberOfGoodPairs {
    public static void main(String[] args) {
        Solution solution = new NumberOfGoodPairs().new Solution();
        int a = solution.addN(0);
        System.out.println(a);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIdenticalPairs(int[] nums) {
            Arrays.sort(nums);
            int res = 0;
            int count = 1;
            for (int i = 1; i < nums.length; i ++){
                if(nums[i] == nums[i-1]) count ++;
                else {
                    res += addN(count);
                    count = 1;
                }
            }

            res += addN(count);
            return res;
        }

        int addN(int n){
            int res = 0;
            while (n > 0){
                res += --n;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}