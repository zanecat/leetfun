//Given two strings text1 and text2, return the length of their longest common s
//ubsequence. If there is no common subsequence, return 0. 
//
// A subsequence of a string is a new string generated from the original string 
//with some characters (can be none) deleted without changing the relative order o
//f the remaining characters. 
//
// 
// For example, "ace" is a subsequence of "abcde". 
// 
//
// A common subsequence of two strings is a subsequence that is common to both s
//trings. 
//
// 
// Example 1: 
//
// 
//Input: text1 = "abcde", text2 = "ace" 
//Output: 3  
//Explanation: The longest common subsequence is "ace" and its length is 3.
// 
//
// Example 2: 
//
// 
//Input: text1 = "abc", text2 = "abc"
//Output: 3
//Explanation: The longest common subsequence is "abc" and its length is 3.
// 
//
// Example 3: 
//
// 
//Input: text1 = "abc", text2 = "def"
//Output: 0
//Explanation: There is no such common subsequence, so the result is 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= text1.length, text2.length <= 1000 
// text1 and text2 consist of only lowercase English characters. 
// 
// Related Topics String Dynamic Programming 
// 👍 3668 👎 43


package q.q1143;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestCommonSubsequence().new Solution();
        solution.longestCommonSubsequence("bmvcnwrmxcfcxabkxcvgbozmpspsbenazglyxkpibgzq", "bmpmlstotylonkvmhqjyxmnqzctonqtobahcrcbibgzgx");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int [][] dp = new int[text1.length() + 1][text2.length() + 1];

            char [] t1 = text1.toCharArray();
            char [] t2 = text2.toCharArray();

            for (int i = 0; i < t1.length; i ++){
                for (int j = 0; j < t2.length; j ++){
                    if (t1[i] == t2[j]){
                        dp[i + 1][j + 1] = dp[i][j] + 1;
                    } else {
                        dp[i+1][j+1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                    }
                }
            }
            return dp[t1.length][t2.length];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}