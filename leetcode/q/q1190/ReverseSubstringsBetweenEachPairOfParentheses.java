//You are given a string s that consists of lower case English letters and brack
//ets. 
//
// Reverse the strings in each pair of matching parentheses, starting from the i
//nnermost one. 
//
// Your result should not contain any brackets. 
//
// 
// Example 1: 
//
// 
//Input: s = "(abcd)"
//Output: "dcba"
// 
//
// Example 2: 
//
// 
//Input: s = "(u(love)i)"
//Output: "iloveu"
//Explanation: The substring "love" is reversed first, then the whole string is 
//reversed.
// 
//
// Example 3: 
//
// 
//Input: s = "(ed(et(oc))el)"
//Output: "leetcode"
//Explanation: First, we reverse the substring "oc", then "etco", and finally, t
//he whole string.
// 
//
// Example 4: 
//
// 
//Input: s = "a(bcdefghijkl(mno)p)q"
//Output: "apmnolkjihgfedcbq"
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 2000 
// s only contains lower case English characters and parentheses. 
// It's guaranteed that all parentheses are balanced. 
// 
// Related Topics String Stack 
// 👍 921 👎 29


package q.q1190;

import java.util.Deque;
import java.util.LinkedList;

public class ReverseSubstringsBetweenEachPairOfParentheses {
    public static void main(String[] args) {
        Solution solution = new ReverseSubstringsBetweenEachPairOfParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseParentheses(String s) {
            char[] chars = s.toCharArray();

            Deque<Character> st1 = new LinkedList<>();
            Deque<Character> st2 = new LinkedList<>();

            for (char c: chars){
                if (c == ')'){
                    while (st1.peek() != '('){
                        st2.push(st1.pop());
                    }

                    st1.pop();
                    while (!st2.isEmpty()){
                        st1.push((st2.pollLast()));
                    }
                } else {
                    st1.push(c);
                }
            }

            StringBuilder sb = new StringBuilder();
            while (!st1.isEmpty()){
                sb.insert(0, st1.pop());
            }

            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}