//Given an arbitrary ransom note string and another string containing letters fr
//om all the magazines, write a function that will return true if the ransom note 
//can be constructed from the magazines ; otherwise, it will return false. 
//
// Each letter in the magazine string can only be used once in your ransom note.
// 
//
// 
// Example 1: 
// Input: ransomNote = "a", magazine = "b"
//Output: false
// Example 2: 
// Input: ransomNote = "aa", magazine = "ab"
//Output: false
// Example 3: 
// Input: ransomNote = "aa", magazine = "aab"
//Output: true
// 
// 
// Constraints: 
//
// 
// You may assume that both strings contain only lowercase letters. 
// 
// Related Topics 字符串 
// 👍 114 👎 0


package q.q383;

public class RansomNote {
  public static void main(String[] args) {
    Solution solution = new RansomNote().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
      int [] count = new int[26];
      for (char c: ransomNote.toCharArray()){
        count[c-97] += 1;
      }

      for (char c: magazine.toCharArray()){
        count[c-97] -= 1;
      }

      for (int i: count){
        if(i>0){
          return false;
        }
      }

      return true;

    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}