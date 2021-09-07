//Given an input string s and a pattern p, implement regular expression matching
// with support for '.' and '*' where: 
//
// 
// '.' Matches any single character. 
// '*' Matches zero or more of the preceding element. 
// 
//
// The matching should cover the entire input string (not partial). 
//
// 
// Example 1: 
//
// 
//Input: s = "aa", p = "a"
//Output: false
//Explanation: "a" does not match the entire string "aa".
// 
//
// Example 2: 
//
// 
//Input: s = "aa", p = "a*"
//Output: true
//Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, 
//by repeating 'a' once, it becomes "aa".
// 
//
// Example 3: 
//
// 
//Input: s = "ab", p = ".*"
//Output: true
//Explanation: ".*" means "zero or more (*) of any character (.)".
// 
//
// Example 4: 
//
// 
//Input: s = "aab", p = "c*a*b"
//Output: true
//Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, i
//t matches "aab".
// 
//
// Example 5: 
//
// 
//Input: s = "mississippi", p = "mis*is*p*."
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 20 
// 1 <= p.length <= 30 
// s contains only lowercase English letters. 
// p contains only lowercase English letters, '.', and '*'. 
// It is guaranteed for each appearance of the character '*', there will be a pr
//evious valid character to match. 
// 
// Related Topics String Dynamic Programming Recursion 
// 👍 6549 👎 925


package q.q010;

public class RegularExpressionMatching {
    public static void main(String[] args) {
        Solution solution = new RegularExpressionMatching().new Solution();
        solution.isMatch("aa", "a*");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {

            char[] ss = (" " + s).toCharArray();
            char[] ps = (" " + p).toCharArray();

            int slen = ss.length;
            int plen = ps.length;

            boolean[][] dp = new boolean[slen + 1][plen + 1];
            dp[0][0] = true;

            for (int i = 1; i <= slen; i ++){
                for (int j = 1; j <= plen; j ++){
                    if (ss[i - 1] == ps[j - 1] || ps[j - 1] == '.'){
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (ps[j - 1] == '*'){
                        dp[i][j] = dp[i][j - 2];
                        if (ps[j - 2] == '.' || ss[i - 1] == ps[j - 2]){
                            dp[i][j] = dp[i][j] || dp[i - 1][j];
                        }
                    }
                }
            }

            return dp[slen][plen];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}