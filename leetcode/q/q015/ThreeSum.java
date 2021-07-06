//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k
//]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0. 
//
// Notice that the solution set must not contain duplicate triplets. 
//
// 
// Example 1: 
// Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
// Example 2: 
// Input: nums = []
//Output: []
// Example 3: 
// Input: nums = [0]
//Output: []
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics Array Two Pointers Sorting 
// 👍 11518 👎 1145


package q.q015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);

            List<List<Integer>> res = new ArrayList<>();


            if (nums.length < 3) return res;
            for (int i = 0; i < nums.length - 2; i ++){
                if (nums[i] > 0) break;
                if (i > 0 && nums[i] == nums[i - 1]) continue;

                int l = i + 1, r = nums.length - 1;

                while (l < r){
                    int sum = nums[i] + nums[l] + nums[r];
                    if (l > i + 1 && nums[l] == nums[l - 1]) {
                        l ++;
                        continue;
                    }

                    if (r < nums.length - 1 && nums[r] == nums[r + 1]){
                        r --;
                        continue;
                    }
                    if (sum == 0){
                        res.add(List.of(nums[i], nums[l], nums[r]));
                        l ++;
//                        r --;
                    } else if (sum > 0) {
                        r --;
                    } else {
                        l ++;
                    }
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}