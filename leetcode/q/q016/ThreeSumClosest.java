//Given an array nums of n integers and an integer target, find three integers i
//n nums such that the sum is closest to target. Return the sum of the three integ
//ers. You may assume that each input would have exactly one solution. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-1,2,1,-4], target = 1
//Output: 2
//Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
// 
//
// 
// Constraints: 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics Array Two Pointers Sorting 
// 👍 3743 👎 187


package q.q016;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new ThreeSumClosest().new Solution();
        solution.threeSumClosest(new int[]{-1,2,1,-4}, 1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int res = nums[0] + nums[1] + nums[2];
            for (int i = 0; i < nums.length; i ++){

                int l = i + 1, r = nums.length - 1;

                while (l < r){
                    int sum =  nums[i] + nums[l] + nums[r];
                    if (Math.abs(target - sum) < Math.abs(res - target)) res = sum;
                    if (sum < target){
                        l ++;
                    } else {
                        r --;
                    }
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}