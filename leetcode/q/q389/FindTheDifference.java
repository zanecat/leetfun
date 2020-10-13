//You are given two strings s and t. 
//
// String t is generated by random shuffling string s and then add one more lett
//er at a random position. 
//
// Return the letter that was added to t. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcd", t = "abcde"
//Output: "e"
//Explanation: 'e' is the letter that was added.
// 
//
// Example 2: 
//
// 
//Input: s = "", t = "y"
//Output: "y"
// 
//
// Example 3: 
//
// 
//Input: s = "a", t = "aa"
//Output: "a"
// 
//
// Example 4: 
//
// 
//Input: s = "ae", t = "aea"
//Output: "a"
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 1000 
// t.length == s.length + 1 
// s and t consist of lower-case English letters. 
// 
// Related Topics 位运算 哈希表 
// 👍 158 👎 0


package q.q389;

public class FindTheDifference {
  public static void main(String[] args) {
    Solution solution = new FindTheDifference().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public char findTheDifference(String s, String t) {

      if(s.length() == 0) return t.charAt(0);
      char res = t.charAt(t.length() - 1);
      for (int i = 0; i < s.length(); i++){
        res ^= s.charAt(i);
        res ^= t.charAt(i);
      }

      return res;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}