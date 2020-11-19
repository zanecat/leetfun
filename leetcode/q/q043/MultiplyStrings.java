//Given two non-negative integers num1 and num2 represented as strings, return t
//he product of num1 and num2, also represented as a string. 
//
// Note: You must not use any built-in BigInteger library or convert the inputs 
//to integer directly. 
//
// 
// Example 1: 
// Input: num1 = "2", num2 = "3"
//Output: "6"
// Example 2: 
// Input: num1 = "123", num2 = "456"
//Output: "56088"
// 
// 
// Constraints: 
//
// 
// 1 <= num1.length, num2.length <= 200 
// num1 and num2 consist of digits only. 
// Both num1 and num2 do not contain any leading zero, except the number 0 itsel
//f. 
// 
// Related Topics Math String 
// 👍 2025 👎 880


package q.q043;

public class MultiplyStrings {
    public static void main(String[] args) {
        Solution solution = new MultiplyStrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            char[] s1 = num1.toCharArray();
            char[] s2 = num2.toCharArray();

            int[] s = new int[s1.length + s2.length];

            for (int i = s1.length - 1; i >= 0; i--) {
                for (int j = s2.length - 1; j >= 0; j--) {
                    s[i + j + 1] += (int) (s1[i] - '0') * (int) (s2[j] - '0');
                }
            }

            int carry = 0;
            for (int i = s.length - 1; i >= 0; i--) {
                int sum = s[i] + carry;
                s[i] = sum % 10;
                carry = sum / 10;
            }
            StringBuilder ans = new StringBuilder();
            int i = 0;
            while (i < s.length - 1 && s[i] == 0) {
                i++;
            }
            while (i < s.length) {
                ans.append(s[i++]);
            }
            return ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}