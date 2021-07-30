//Implement strStr(). 
//
// Return the index of the first occurrence of needle in haystack, or -1 if need
//le is not part of haystack. 
//
// Clarification: 
//
// What should we return when needle is an empty string? This is a great questio
//n to ask during an interview. 
//
// For the purpose of this problem, we will return 0 when needle is an empty str
//ing. This is consistent to C's strstr() and Java's indexOf(). 
//
// 
// Example 1: 
// Input: haystack = "hello", needle = "ll"
//Output: 2
// Example 2: 
// Input: haystack = "aaaaa", needle = "bba"
//Output: -1
// Example 3: 
// Input: haystack = "", needle = ""
//Output: 0
// 
// 
// Constraints: 
//
// 
// 0 <= haystack.length, needle.length <= 5 * 104 
// haystack and needle consist of only lower-case English characters. 
// 
// Related Topics Two Pointers String String Matching 
// 👍 2697 👎 2587


package q.q028;

public class ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new ImplementStrstr().new Solution();
        solution.strStr("mississippi", "issip");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String s, String p) {
            int m = s.length();
            int n = p.length();
            if (n == 0) return 0;
            char [] ss = s.toCharArray();
            char [] pp = p.toCharArray();

            int [] dp = new int[n];

            for (int i = 0, j = 1; j < n; j ++){
                while (i > 0 && pp[i] != pp[j]) i = dp[i - 1];
                if (pp[i] == pp[j]) i ++;
                dp[j] = i;
            }

            for (int i = 0, j = 0; j < m; j ++){
                while (i > 0 && pp[i] != ss[j]) i = dp[i - 1];
                if (pp[i] == ss[j]) i ++;

                if (i == n) return j - n + 1;
            }

            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}