//A message containing letters from A-Z can be encoded into numbers using the fo
//llowing mapping: 
//
// 
//'A' -> "1"
//'B' -> "2"
//...
//'Z' -> "26"
// 
//
// To decode an encoded message, all the digits must be grouped then mapped back
// into letters using the reverse of the mapping above (there may be multiple ways
//). For example, "11106" can be mapped into: 
//
// 
// "AAJF" with the grouping (1 1 10 6) 
// "KJF" with the grouping (11 10 6) 
// 
//
// Note that the grouping (1 11 06) is invalid because "06" cannot be mapped int
//o 'F' since "6" is different from "06". 
//
// Given a string s containing only digits, return the number of ways to decode 
//it. 
//
// The answer is guaranteed to fit in a 32-bit integer. 
//
// 
// Example 1: 
//
// 
//Input: s = "12"
//Output: 2
//Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
// 
//
// Example 2: 
//
// 
//Input: s = "226"
//Output: 3
//Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2
// 6).
// 
//
// Example 3: 
//
// 
//Input: s = "0"
//Output: 0
//Explanation: There is no character that is mapped to a number starting with 0.
//
//The only valid mappings with 0 are 'J' -> "10" and 'T' -> "20", neither of whi
//ch start with 0.
//Hence, there are no valid ways to decode this since all digits need to be mapp
//ed.
// 
//
// Example 4: 
//
// 
//Input: s = "06"
//Output: 0
//Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is 
//different from "06").
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 100 
// s contains only digits and may contain leading zero(s). 
// 
// Related Topics String Dynamic Programming 
// 👍 4896 👎 3531


package q.q091;

public class DecodeWays {
    public static void main(String[] args) {
        Solution solution = new DecodeWays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDecodings(String s) {
            int [] dp = new int[s.length() + 1];
            char [] chars = (" "+s).toCharArray();
            dp[0] = 1;
            for (int i = 1; i < dp.length; i ++){
                char c = chars[i];
                if (c - '0' >= 1 && c - '0' <= 9){
                    dp[i] = dp[i - 1];
                }


                if (i > 1){
                    int n = (chars[i - 1] - '0') * 10 + (c - '0');
                    if (n >= 10 && n <= 26){
                        dp[i] += dp[i - 2];
                    }
                }
            }
            return dp[s.length()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}