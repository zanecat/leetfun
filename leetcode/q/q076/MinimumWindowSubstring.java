//Given two strings s and t of lengths m and n respectively, return the minimum 
//window substring of s such that every character in t (including duplicates) is i
//ncluded in the window. If there is no such substring, return the empty string ""
//. 
//
// The testcases will be generated such that the answer is unique. 
//
// A substring is a contiguous sequence of characters within the string. 
//
// 
// Example 1: 
//
// 
//Input: s = "ADOBECODEBANC", t = "ABC"
//Output: "BANC"
//Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' fr
//om string t.
// 
//
// Example 2: 
//
// 
//Input: s = "a", t = "a"
//Output: "a"
//Explanation: The entire string s is the minimum window.
// 
//
// Example 3: 
//
// 
//Input: s = "a", t = "aa"
//Output: ""
//Explanation: Both 'a's from t must be included in the window.
//Since the largest window of s only has one 'a', return empty string.
// 
//
// 
// Constraints: 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 105 
// s and t consist of uppercase and lowercase English letters. 
// 
//
// 
//Follow up: Could you find an algorithm that runs in O(m + n) time? Related Top
//ics Hash Table String Sliding Window 
// 👍 7854 👎 488


package q.q076;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        solution.minWindow("ADOBECODEBANC", "ABC");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            char[] ss = s.toCharArray(), tt = t.toCharArray();

            int [] tcnt = new int[128];
            int [] scnt = new int[128];

            int tlen = t.length();

            for (char c : tt){
                tcnt[c - 'A'] ++;
            }

            int count = 0;
            boolean good = false;
            int res = s.length() + 1;
            int ri = 0, rj = 0;

            for (int i = 0, j = 0; j < s.length(); j ++){
                int charj = ss[j] - 'A';

                if (tcnt[charj] > 0){
                    scnt[charj]++;

                    if (scnt[charj] <= tcnt[charj]){
                        if (++count == tlen){
                            good = true;
                        }
                    }
                }

                while (i < j ){
                    int chari = ss[i] - 'A';

                    if (tcnt[chari] > 0){
                        if (scnt[chari] > tcnt[chari]){
                            scnt[chari] --;
                            i ++;
                        } else {
                            break;
                        }
                    } else {
                        i++;
                    }
                }

                if (good){
                    if(j - i + 1 < res){
                        res = j - i + 1;
                        ri = i;
                        rj = j + 1;
                    }
                }
            }

            return s.substring(ri, rj);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}