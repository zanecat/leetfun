//Evaluate the value of an arithmetic expression in Reverse Polish Notation. 
//
// Valid operators are +, -, *, and /. Each operand may be an integer or another
// expression. 
//
// Note that division between two integers should truncate toward zero. 
//
// It is guaranteed that the given RPN expression is always valid. That means th
//e expression would always evaluate to a result, and there will not be any divisi
//on by zero operation. 
//
// 
// Example 1: 
//
// 
//Input: tokens = ["2","1","+","3","*"]
//Output: 9
//Explanation: ((2 + 1) * 3) = 9
// 
//
// Example 2: 
//
// 
//Input: tokens = ["4","13","5","/","+"]
//Output: 6
//Explanation: (4 + (13 / 5)) = 6
// 
//
// Example 3: 
//
// 
//Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
//Output: 22
//Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
//= ((10 * (6 / (12 * -11))) + 17) + 5
//= ((10 * (6 / -132)) + 17) + 5
//= ((10 * 0) + 17) + 5
//= (0 + 17) + 5
//= 17 + 5
//= 22
// 
//
// 
// Constraints: 
//
// 
// 1 <= tokens.length <= 104 
// tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the 
//range [-200, 200]. 
// 
// Related Topics Array Math Stack 
// 👍 2077 👎 556


package q.q150;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        Solution solution = new EvaluateReversePolishNotation().new Solution();
        solution.evalRPN(new String[]{"2","1","+","3","*"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int evalRPN(String[] tokens) {
            int [] nums = new int[tokens.length];
            int in = -1;
            for (String t: tokens){
                if (t.equals("/")){
                    int i = nums[in--];
                    int j = nums[in--];
                    nums[in] = (j/i);
                } else if (t.equals("*")){
                    int i = nums[in--];
                    int j = nums[in--];
                    nums[in] = (j*i);
                } else if (t.equals("+")){
                    int i = nums[in--];
                    int j = nums[in--];
                    nums[in] = (j+i);
                } else if (t.equals("-")){
                    int i = nums[in--];
                    int j = nums[in--];
                    nums[in] = (j-i);
                } else {
                    in ++;
                    nums[in] = (Integer.parseInt(t));
                }
            }

            return nums[in];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}