//Given an input string s, reverse the order of the words. 
//
// A word is defined as a sequence of non-space characters. The words in s will 
//be separated by at least one space. 
//
// Return a string of the words in reverse order concatenated by a single space.
// 
//
// Note that s may contain leading or trailing spaces or multiple spaces between
// two words. The returned string should only have a single space separating the w
//ords. Do not include any extra spaces. 
//
// 
// Example 1: 
//
// 
//Input: s = "the sky is blue"
//Output: "blue is sky the"
// 
//
// Example 2: 
//
// 
//Input: s = "  hello world  "
//Output: "world hello"
//Explanation: Your reversed string should not contain leading or trailing space
//s.
// 
//
// Example 3: 
//
// 
//Input: s = "a good   example"
//Output: "example good a"
//Explanation: You need to reduce multiple spaces between two words to a single 
//space in the reversed string.
// 
//
// Example 4: 
//
// 
//Input: s = "  Bob    Loves  Alice   "
//Output: "Alice Loves Bob"
// 
//
// Example 5: 
//
// 
//Input: s = "Alice does not even like bob"
//Output: "bob like even not does Alice"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 104 
// s contains English letters (upper-case and lower-case), digits, and spaces ' 
//'. 
// There is at least one word in s. 
// 
//
// 
// Follow-up: If the string data type is mutable in your language, can you solve
// it in-place with O(1) extra space? 
// Related Topics Two Pointers String 
// 👍 1940 👎 3385


package q.q151;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            Stack<String> stack = new Stack<>();

            int i = 0;
            while (i < s.length()){
                while (i < s.length() && s.charAt(i) == ' '){
                    i ++;
                }

                int start = i;
                while (i < s.length() && s.charAt(i) != ' '){
                    i ++;
                }
                stack.push(s.substring(start, i));
            }

            StringBuilder res = new StringBuilder();
            while (!stack.empty()){
                res.append(" ").append(stack.pop());
            }

            return res.toString().trim();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}