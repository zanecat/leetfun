//Given a string s consists of some words separated by spaces, return the length
// of the last word in the string. If the last word does not exist, return 0. 
//
// A word is a maximal substring consisting of non-space characters only. 
//
// 
// Example 1: 
// Input: s = "Hello World"
//Output: 5
// Example 2: 
// Input: s = " "
//Output: 0
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 104 
// s consists of only English letters and spaces ' '. 
// 
// Related Topics String 
// 👍 1248 👎 3401


package q.q058;

public class LengthOfLastWord {
    public static void main(String[] args) {
        Solution solution = new LengthOfLastWord().new Solution();
        solution.lengthOfLastWord("b   a   ");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLastWord(String s) {
            char [] chars = s.toCharArray();

            int res = 0;
            boolean started = false;
            for (int i = s.length() - 1; i >= 0; i --){
                if (chars[i] == ' '){
                    if (started) return res;
                } else {
                    if (!started) started = true;
                    res ++;
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}