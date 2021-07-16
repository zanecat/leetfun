//You are given an integer array nums and an integer target. 
//
// You want to build an expression out of nums by adding one of the symbols '+' 
//and '-' before each integer in nums and then concatenate all the integers. 
//
// 
// For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 
//and concatenate them to build the expression "+2-1". 
// 
//
// Return the number of different expressions that you can build, which evaluate
//s to target. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,1,1,1], target = 3
//Output: 5
//Explanation: There are 5 ways to assign symbols to make the sum of nums be tar
//get 3.
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// Example 2: 
//
// 
//Input: nums = [1], target = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
// Related Topics Array Dynamic Programming Backtracking 
// 👍 4636 👎 184


package q.q494;

public class TargetSum {
    public static void main(String[] args) {
        Solution solution = new TargetSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int res = 0;
        int len;
        int [] nums;
        int tar;
        public int findTargetSumWays(int[] nums, int target) {
            len = nums.length - 1;
            this.nums = nums;
            tar = target;

            my(0, 0);
            return res;
        }

        void my(int i, int curr){
            int add = curr + nums[i];
            int minus = curr - nums[i];

            if (i == len){
                if (add == tar) res++;
                if (minus == tar) res++;
            } else {
                my(i + 1, add);
                my(i + 1, minus);
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}