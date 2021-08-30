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
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        solution.permute(new int[]{1,2,3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used;
        public List<List<Integer>> permute(int[] nums) {
            Deque<Integer> list = new LinkedList<>();
            used = new boolean[nums.length];
            bt(nums, list);
            return res;
        }

        void bt(int[] nums, Deque<Integer> list){
            if (list.size() == nums.length){
                res.add(new ArrayList<>(list));
                return;
            }
            for (int i = 0; i < nums.length; i ++){
                if (!used[i]){
                    used[i] =true;
                    list.push(nums[i]);
                    bt(nums, list);
                    list.pop();
                    used[i] = false;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}