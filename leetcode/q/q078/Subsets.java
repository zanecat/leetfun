//Given an integer array nums of unique elements, return all possible subsets (t
//he power set). 
//
// The solution set must not contain duplicate subsets. Return the solution in a
//ny order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3]
//Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// Example 2: 
//
// 
//Input: nums = [0]
//Output: [[],[0]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// All the numbers of nums are unique. 
// 
// Related Topics Array Backtracking Bit Manipulation 
// 👍 6311 👎 116


package q.q078;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
        solution.subsets(new int[]{1,2,3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        int [] nums = null;
        public List<List<Integer>> subsets(int[] nums) {
            this.nums = nums;
            myFun(0, new ArrayList<>());
            return res;
        }

        void myFun(int curr, List<Integer> ll){
            res.add(new ArrayList<>(ll));
            for (int i = curr; i < nums.length; i ++){
                ll.add(nums[i]);
                myFun(i + 1, ll);
                ll.remove(ll.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}