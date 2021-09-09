//Given a string s which represents an expression, evaluate this expression and 
//return its value. 
//
// The integer division should truncate toward zero. 
//
// You may assume that the given expression is always valid. All intermediate re
//sults will be in the range of [-231, 231 - 1]. 
//
// Note: You are not allowed to use any built-in function which evaluates string
//s as mathematical expressions, such as eval(). 
//
// 
// Example 1: 
// Input: s = "3+2*2"
//Output: 7
// Example 2: 
// Input: s = " 3/2 "
//Output: 1
// Example 3: 
// Input: s = " 3+5 / 2 "
//Output: 5
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 3 * 105 
// s consists of integers and operators ('+', '-', '*', '/') separated by some n
//umber of spaces. 
// s represents a valid expression. 
// All the integers in the expression are non-negative integers in the range [0,
// 231 - 1]. 
// The answer is guaranteed to fit in a 32-bit integer. 
// 
// Related Topics Math String Stack 
// 👍 2763 👎 414


package q.q227;

import java.util.*;

public class BasicCalculatorIi {
    public static void main(String[] args) {
        Solution solution = new BasicCalculatorIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            char[] chars = s.replace(" ", "").toCharArray();

            Deque<Character> ops = new LinkedList<>();
            Deque<Integer> nums = new LinkedList<>();

            Map<Character, Integer> prio = new HashMap<>();

            prio.put('(', 0);
            prio.put(')', 0);
            prio.put('+', 1);
            prio.put('-', 1);
            prio.put('/', 2);
            prio.put('*', 2);

            for (int i = 0; i < chars.length; i++) {
                if (isDigit(chars[i])) {
                    int n = 0;
                    while (i < chars.length && isDigit(chars[i])) {
                        n = n * 10 + (chars[i] - '0');
                        i++;
                    }

                    i--;

                    nums.push(n);
                } else if (chars[i] == '(') {
                    ops.push('(');
                } else if (chars[i] == ')') {
                    while (ops.peek() != '('){
                        int n1 = nums.pop();
                        int n2 = nums.pop();
                        char op = ops.pop();

                        nums.push(calc(n1, n2, op));
                    }
                    ops.pop();
                } else {
                    while (!ops.isEmpty() && prio.get(ops.peek()) >= prio.get(chars[i])){
                        int n1 = nums.pop();
                        int n2 = nums.pop();
                        char op = ops.pop();

                        nums.push(calc(n1, n2, op));
                    }
                    ops.push(chars[i]);
                }
            }

            while (!ops.isEmpty()){
                int n1 = nums.pop();
                int n2 = nums.pop();
                char op = ops.pop();

                nums.push(calc(n1, n2, op));
            }

            return nums.pop();
        }

        boolean isDigit(char c) {
            return Character.isDigit(c);
        }

        int calc(int n1, int n2, char op){
            switch (op){
                case '+':
                    return n1 + n2;
                case '-':
                    return n2 - n1;
                case '*':
                    return n2 * n1;
                case '/':
                    return n2/n1;
                default:
                    return 0;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}