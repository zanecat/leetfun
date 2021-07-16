//Given a non-empty array nums containing only positive integers, find if the ar
//ray can be partitioned into two subsets such that the sum of elements in both su
//bsets is equal. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,5,11,5]
//Output: true
//Explanation: The array can be partitioned as [1, 5, 5] and [11].
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,5]
//Output: false
//Explanation: The array cannot be partitioned into equal sum subsets.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics Array Dynamic Programming 
// 👍 4860 👎 94


package q.q416;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new PartitionEqualSubsetSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int n:nums){
                sum += n;
            }

            if (sum%2 == 1) return false;

            int target = sum/2;

            boolean [][] dp = new boolean[nums.length][target + 1];

            for (int i = 1; i < nums.length; i ++){
                for (int j = 0; j < target + 1; j ++){
                    dp[i][j] = dp[i - 1][j];

                    if (nums[i] == j) {
                        dp[i][j] = true;
                        continue;
                    }
                    if (nums[i] < j) {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                    }
                }
            }

            return dp[nums.length - 1][target];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}