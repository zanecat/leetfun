//There is a forest with an unknown number of rabbits. We asked n rabbits "How m
//any rabbits have the same color as you?" and collected the answers in an integer
// array answers where answers[i] is the answer of the ith rabbit. 
//
// Given the array answers, return the minimum number of rabbits that could be i
//n the forest. 
//
// 
// Example 1: 
//
// 
//Input: answers = [1,1,2]
//Output: 5
//Explanation:
//The two rabbits that answered "1" could both be the same color, say red.
//The rabbit that answered "2" can't be red or the answers would be inconsistent
//.
//Say the rabbit that answered "2" was blue.
//Then there should be 2 other blue rabbits in the forest that didn't answer int
//o the array.
//The smallest possible number of rabbits in the forest is therefore 5: 3 that a
//nswered plus 2 that didn't.
// 
//
// Example 2: 
//
// 
//Input: answers = [10,10,10]
//Output: 11
// 
//
// 
// Constraints: 
//
// 
// 1 <= answers.length <= 1000 
// 0 <= answers[i] < 1000 
// 
// Related Topics Hash Table Math Greedy 
// 👍 487 👎 411


package q.q781;

import java.util.HashMap;
import java.util.Map;

public class RabbitsInForest {
    public static void main(String[] args) {
        Solution solution = new RabbitsInForest().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numRabbits(int[] answers) {
            Map<Integer, Integer> records = new HashMap<>();
            int res = 0;
            for (int a : answers){
                int count = records.getOrDefault(a, 0);

                if (count >= a + 1){
                    res += a + 1;
                    records.put(a, 1);
                } else {
                    records.put(a, count + 1);
                }
            }

            for (int k: records.keySet()){
                res += k + 1;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}