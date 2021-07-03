//Given a string containing digits from 2-9 inclusive, return all possible lette
//r combinations that the number could represent. Return the answer in any order. 
//
//
// A mapping of digit to letters (just like on the telephone buttons) is given b
//elow. Note that 1 does not map to any letters. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// Example 2: 
//
// 
//Input: digits = ""
//Output: []
// 
//
// Example 3: 
//
// 
//Input: digits = "2"
//Output: ["a","b","c"]
// 
//
// 
// Constraints: 
//
// 
// 0 <= digits.length <= 4 
// digits[i] is a digit in the range ['2', '9']. 
// 
// Related Topics Hash Table String Backtracking 
// 👍 6521 👎 546


package q.q017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCombinations(String digits) {
            Map<Character, String> chars = new HashMap<>();
            chars.put('2', "abc");
            chars.put('3', "def");
            chars.put('4', "ghi");
            chars.put('5', "jkl");
            chars.put('6', "mno");
            chars.put('7', "pqrs");
            chars.put('8', "tuv");
            chars.put('9', "wxyz");

            List<String> res = new ArrayList<>();

            if (digits.equals("")){
                return res;
            }

            bt(res, digits, new StringBuilder(), chars);

            return res;
        }

        void bt(List<String> res, String digits, StringBuilder sb, Map<Character, String> chars){
            if (digits.length() == 0) {
                res.add(sb.toString());
                return;
            }

            String currChars = chars.get(digits.charAt(0));
            for (int i = 0; i < currChars.length(); i ++){
                StringBuilder newsb = new StringBuilder(sb.toString());
                newsb.append(currChars.charAt(i));
                {
                    bt(res, digits.substring(1), newsb, chars);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}