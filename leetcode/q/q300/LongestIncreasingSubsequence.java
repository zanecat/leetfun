//Given an integer array nums, return the length of the longest strictly increas
//ing subsequence. 
//
// A subsequence is a sequence that can be derived from an array by deleting som
//e or no elements without changing the order of the remaining elements. For examp
//le, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7]. 
//
// 
// Example 1: 
//
// 
//Input: nums = [10,9,2,5,3,7,101,18]
//Output: 4
//Explanation: The longest increasing subsequence is [2,3,7,101], therefore the 
//length is 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1,0,3,2,3]
//Output: 4
// 
//
// Example 3: 
//
// 
//Input: nums = [7,7,7,7,7,7,7]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2500 
// -104 <= nums[i] <= 104 
// 
//
// 
// Follow up: Can you come up with an algorithm that runs in O(n log(n)) time co
//mplexity? 
// Related Topics Array Binary Search Dynamic Programming 
// 👍 8170 👎 175


package q.q300;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
        solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int [] tails = new int[nums.length];

            tails[0] = nums[0];

            int pos = 0;

            for (int n : nums){
                int l = 0, r = pos;

                while (l < r){
                    int mid = l + (r - l)/2;
                    if (tails[mid] < n){
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }

                tails[l] = n;
                if (pos == l){
                    pos++;
                }
            }

            return pos;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}