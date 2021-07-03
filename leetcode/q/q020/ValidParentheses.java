//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']
//', determine if the input string is valid. 
//
// An input string is valid if: 
//
// 
// Open brackets must be closed by the same type of brackets. 
// Open brackets must be closed in the correct order. 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "()"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "()[]{}"
//Output: true
// 
//
// Example 3: 
//
// 
//Input: s = "(]"
//Output: false
// 
//
// Example 4: 
//
// 
//Input: s = "([)]"
//Output: false
// 
//
// Example 5: 
//
// 
//Input: s = "{[]}"
//Output: true
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 104 
// s consists of parentheses only '()[]{}'. 
// 
// Related Topics String Stack 
// 👍 7983 👎 326


package q.q020;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> st = new Stack<>();

            for (int i = 0; i < s.length(); i ++){
                char curr = s.charAt(i);
                if (curr == '(' || curr =='[' || curr == '{'){
                    st.push(curr);
                } else {
                    if (st.isEmpty()) return false;
                    else {
                        char top = st.pop();
                        if ((top != '(' || curr != ')') && (top != '[' || curr != ']') && (top != '{' || curr != '}')) {
                            return false;
                        }
                    }

                }
            }

            return st.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}