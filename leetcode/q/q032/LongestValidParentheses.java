//Given a string containing just the characters '(' and ')', find the length of 
//the longest valid (well-formed) parentheses substring. 
//
// 
// Example 1: 
//
// 
//Input: s = "(()"
//Output: 2
//Explanation: The longest valid parentheses substring is "()".
// 
//
// Example 2: 
//
// 
//Input: s = ")()())"
//Output: 4
//Explanation: The longest valid parentheses substring is "()()".
// 
//
// Example 3: 
//
// 
//Input: s = ""
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 3 * 104 
// s[i] is '(', or ')'. 
// 
// Related Topics String Dynamic Programming Stack 
// 👍 5532 👎 194


package q.q032;

import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new LongestValidParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses(String s) {
            int res = 0;
            int count = 0;

            Stack<Integer> st = new Stack<>();
            boolean [] mark = new boolean[s.length()];

            for (int i = 0; i < s.length(); i ++){
                if (s.charAt(i) == '('){
                    st.push(i);
                } else {
                    if (!st.empty()){
                        mark[i] = true;
                        mark[st.pop()] = true;
                    }
                }
            }

            for (boolean i : mark){
                if (i){
                    count ++;
                } else {
                    res = Math.max(res, count);
                    count = 0;
                }
            }

            return Math.max(res, count);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}