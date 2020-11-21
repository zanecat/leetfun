//Given a word, you need to judge whether the usage of capitals in it is right o
//r not. 
//
// We define the usage of capitals in a word to be right when one of the followi
//ng cases holds: 
//
// 
// All letters in this word are capitals, like "USA". 
// All letters in this word are not capitals, like "leetcode". 
// Only the first letter in this word is capital, like "Google". 
// 
//Otherwise, we define that this word doesn't use capitals in a right way.
//
// 
//
// Example 1: 
//
// 
//Input: "USA"
//Output: True
// 
//
// 
//
// Example 2: 
//
// 
//Input: "FlaG"
//Output: False
// 
//
// 
//
// Note: The input will be a non-empty word consisting of uppercase and lowercas
//e latin letters. 
// Related Topics 字符串 
// 👍 109 👎 0

  
package q.q520;
  
public class DetectCapital{
  public static void main(String[] args) {
    Solution solution = new DetectCapital().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean detectCapitalUse(String word) {

      int len = word.length();
      int count = 0;
      for (int i = 0; i < len; i++) {
        char s = word.charAt(i);
        if (s >= 'A' && s <= 'Z') {
          count++;
        }
      }
      return count == len || count == 0
          || (count == 1 && word.charAt(0) >= 'A' && word.charAt(0) <= 'Z');

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}