//Given n pairs of parentheses, write a function to generate all combinations of
// well-formed parentheses. 
//
// 
// Example 1: 
// Input: n = 3
//Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2: 
// Input: n = 1
//Output: ["()"]
// 
// 
// Constraints: 
//
// 
// 1 <= n <= 8 
// 
// Related Topics String Dynamic Programming Backtracking 
// 👍 8613 👎 354


package q.q022;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        System.out.println(solution.generateParenthesis(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            bt(res, n, n, new StringBuilder());

            return res;
        }

        void bt(List<String> res, int open, int close, StringBuilder sb){
            if (open > close) return;

            if (open == 0){
                res.add(sb.toString() + ")".repeat(close));
                return;
            }

            sb.append("(");
            bt(res, open - 1, close, sb);
            sb.deleteCharAt(sb.length() - 1);

            sb.append(")");
            bt(res, open, close - 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}