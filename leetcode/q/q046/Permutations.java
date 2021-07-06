//Given an array nums of distinct integers, return all the possible permutations
//. You can return the answer in any order. 
//
// 
// Example 1: 
// Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// Example 2: 
// Input: nums = [0,1]
//Output: [[0,1],[1,0]]
// Example 3: 
// Input: nums = [1]
//Output: [[1]]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// All the integers of nums are unique. 
// 
// Related Topics Array Backtracking 
// 👍 6637 👎 139


package q.q046;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        solution.permute(new int[]{1,2,3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        boolean [] used = null;
        int[] nums = null;
        public List<List<Integer>> permute(int[] nums) {
            used = new boolean[nums.length];
            this.nums = nums;

            backtrace(new ArrayList<>());

            return res;
        }

        void backtrace(List<Integer> list){
            if (list.size() == used.length){
                res.add(new ArrayList<>(list));
                return;
            }

            for (int i = 0; i < used.length; i ++){
                if (!used[i]){
                    list.add(nums[i]);
                    used[i] = true;
                    backtrace(list);
                    used[i] = false;
                    list.remove(list.size() - 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}