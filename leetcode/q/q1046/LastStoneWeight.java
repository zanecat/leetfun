//You are given an array of integers stones where stones[i] is the weight of the
// ith stone. 
//
// We are playing a game with the stones. On each turn, we choose the heaviest t
//wo stones and smash them together. Suppose the heaviest two stones have weights 
//x and y with x <= y. The result of this smash is: 
//
// 
// If x == y, both stones are destroyed, and 
// If x != y, the stone of weight x is destroyed, and the stone of weight y has 
//new weight y - x. 
// 
//
// At the end of the game, there is at most one stone left. 
//
// Return the smallest possible weight of the left stone. If there are no stones
// left, return 0. 
//
// 
// Example 1: 
//
// 
//Input: stones = [2,7,4,1,8,1]
//Output: 1
//Explanation: 
//We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
//we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
//we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
//we combine 1 and 1 to get 0 so the array converts to [1] then that's the value
// of the last stone.
// 
//
// Example 2: 
//
// 
//Input: stones = [1]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= stones.length <= 30 
// 1 <= stones[i] <= 1000 
// 
// Related Topics Array Heap (Priority Queue) 
// 👍 1611 👎 41


package q.q1046;

import java.util.PriorityQueue;

public class LastStoneWeight {
    public static void main(String[] args) {
        Solution solution = new LastStoneWeight().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lastStoneWeight(int[] stones) {
            PriorityQueue<Integer> q = new PriorityQueue<>((i, j) -> j - i);

            for (int s : stones){
                q.add(s);
            }
            int res = 0;
            while (!q.isEmpty()){
                int s1 = q.poll();
                if (!q.isEmpty()){
                    q.offer(s1 - q.poll());
                } else {
                    res = s1;
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}