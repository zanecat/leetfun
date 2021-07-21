//Given a collection of candidate numbers (candidates) and a target number (targ
//et), find all unique combinations in candidates where the candidate numbers sum 
//to target. 
//
// Each number in candidates may only be used once in the combination. 
//
// Note: The solution set must not contain duplicate combinations. 
//
// 
// Example 1: 
//
// 
//Input: candidates = [10,1,2,7,6,1,5], target = 8
//Output: 
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//]
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,5,2,1,2], target = 5
//Output: 
//[
//[1,2,2],
//[5]
//]
// 
//
// 
// Constraints: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// Related Topics Array Backtracking 
// 👍 3187 👎 95


package q.q040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIi().new Solution();
        solution.combinationSum2(new int[]{2,1,1}, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        int[] candi;
        int tar;
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            candi = candidates;
            tar = target;
            Arrays.sort(candidates);
            bt(0, 0, new ArrayList<>());

            return res;
        }

        void bt(int start, int sum, List<Integer> list){
            if (sum == tar){
                res.add(new ArrayList<>(list));
                return;
            }

            if (sum > tar) return;

            for (int i = start; i < candi.length; i ++){
                if (i > start && candi[i] == candi[i - 1]) {
                    continue;
                }
                list.add(candi[i]);
                bt(i + 1, sum + candi[i], list);
                list.remove(list.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}