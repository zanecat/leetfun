//Given a collection of numbers, nums, that might contain duplicates, return all
// possible unique permutations in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,2]
//Output:
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics Array Backtracking 
// 👍 3346 👎 82


package q.q047;

import java.util.*;

public class PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            boolean [] used = new boolean[nums.length];
            Arrays.sort(nums);
            backtracking(nums, used);
            return result;
        }

        LinkedList<Integer> path = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        public void backtracking(int[] nums, boolean[] used){
            // 选中一个元素，其他的任意选，但是不能相等
            if(path.size() == nums.length){
                result.add(new ArrayList<>(path));
                return;
            }
            for(int i=0;i<nums.length;i++){
                if(used[i]){
                    continue;
                }
                if(i> 0 && nums[i] == nums[i-1] && !used[i-1]){
                    continue;
                }
                path.add(nums[i]);
                used[i] = true;
                backtracking(nums, used);
                path.removeLast();
                used[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}