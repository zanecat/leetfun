//You are given a string s and an integer k. You can choose any character of the
// string and change it to any other uppercase English character. You can perform 
//this operation at most k times. 
//
// Return the length of the longest substring containing the same letter you can
// get after performing the above operations. 
//
// 
// Example 1: 
//
// 
//Input: s = "ABAB", k = 2
//Output: 4
//Explanation: Replace the two 'A's with two 'B's or vice versa.
// 
//
// Example 2: 
//
// 
//Input: s = "AABABBA", k = 1
//Output: 4
//Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
//The substring "BBBB" has the longest repeating letters, which is 4.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 105 
// s consists of only uppercase English letters. 
// 0 <= k <= s.length 
// 
// Related Topics Hash Table String Sliding Window 
// 👍 2828 👎 128


package editor.en;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        Solution solution = new LongestRepeatingCharacterReplacement().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int characterReplacement(String s, int k) {
            int l = 0, r = 0, maxN = 0;
            int [] counts = new int[26];
            while (r < s.length()){
                counts[s.charAt(r) - 'A']++;
                maxN = Math.max(maxN, counts[s.charAt(r) - 'A']);
                if (r - l + 1 - maxN > k){
                    counts[s.charAt(l++) - 'A']--;
                }
                r ++;
            }

            return r - l;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}