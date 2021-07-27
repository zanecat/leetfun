//Given an integer array nums that may contain duplicates, return all possible s
//ubsets (the power set). 
//
// The solution set must not contain duplicate subsets. Return the solution in a
//ny order. 
//
// 
// Example 1: 
// Input: nums = [1,2,2]
//Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
// Example 2: 
// Input: nums = [0]
//Output: [[],[0]]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
// Related Topics Array Backtracking Bit Manipulation 
// 👍 2950 👎 114


package q.q090;

import java.util.*;

public class SubsetsIi {
    public static void main(String[] args) {
        Solution solution = new SubsetsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            bt(nums, 0, new LinkedList<>());
            return res;
        }

        void bt(int[] nums, int start, Deque<Integer> ll){
            if (start > nums.length) return;
            res.add(new ArrayList<>(ll));

            for (int i = start; i < nums.length; i ++){
                if (i > start && nums[i] == nums[i - 1]) continue;
                else {
                    ll.add(nums[i]);
                    bt(nums, i + 1, ll);
                    ll.removeLast();
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}