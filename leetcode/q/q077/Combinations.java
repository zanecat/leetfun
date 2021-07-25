//Given two integers n and k, return all possible combinations of k numbers out 
//of the range [1, n]. 
//
// You may return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: n = 4, k = 2
//Output:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// 
//
// Example 2: 
//
// 
//Input: n = 1, k = 1
//Output: [[1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics Array Backtracking 
// 👍 2570 👎 90


package q.q077;

import java.util.*;

public class Combinations {
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new LinkedList<>();
        public List<List<Integer>> combine(int n, int k) {
            Deque<Integer> ll = new ArrayDeque<>();

            bt(ll, n, k);
            return res;
        }

        void bt(Deque<Integer> ll, int n, int k){
            if (k == ll.size()){
                res.add(new ArrayList<>(ll));
                return;
            }
            for (int i = n; i >= n + 1 - k + ll.size(); i --){
                ll.addLast(i);
                bt(ll, i-1, k);
                ll.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}