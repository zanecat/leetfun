//Given a string s, return the longest palindromic substring in s. 
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// Example 3: 
//
// 
//Input: s = "a"
//Output: "a"
// 
//
// Example 4: 
//
// 
//Input: s = "ac"
//Output: "a"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters (lower-case and/or upper-case), 
//
// 
// Related Topics String Dynamic Programming 
// 👍 11610 👎 726


package q.q005;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        solution.longestPalindrome("aaaa");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            boolean [][] dp = new boolean[s.length()][s.length()];
            int l = 0, r = 0, res = -1;
            for (int i = 0; i < s.length(); i ++){
                dp[i][i] = true;
                if( i + 1 < s.length() && s.charAt(i) == s.charAt(i+1)){
                    dp[i][i + 1] = true;
                    l = i;
                    r = i + 1;
                    res = 2;
                }
            }

            for (int n = 2; n < s.length(); n ++){
                for (int i = 0; i + n < s.length(); i ++){
                    if (s.charAt(i) == s.charAt(i+n)){
                        dp[i][i+n] = dp[i+1][i+n-1];
                    }

                    if (dp[i][i+n]){
                        if (n + 1 > res){
                            l = i;
                            r = i + n;
                            res = n + 1;
                        }
                    }
                }
            }

            return s.substring(l, r + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}