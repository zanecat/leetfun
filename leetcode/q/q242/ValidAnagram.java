//Given two strings s and t , write a function to determine if t is an anagram o
//f s. 
//
// Example 1: 
//
// 
//Input: s = "anagram", t = "nagaram"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "rat", t = "car"
//Output: false
// 
//
// Note: 
//You may assume the string contains only lowercase alphabets. 
//
// Follow up: 
//What if the inputs contain unicode characters? How would you adapt your soluti
//on to such case? 
// Related Topics 排序 哈希表 
// 👍 261 👎 0


package q.q242;

public class ValidAnagram {
  public static void main(String[] args) {
    Solution solution = new ValidAnagram().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean isAnagram(String s, String t) {
      int [] count = new int[26];
      if(s.length() != t.length()) return false;
      if(s.length() == 0) return true;
      for (int i =0; i < s.length(); i++){
        count[s.charAt(i) - 97] += 1;
        count[t.charAt(i) - 97] -= 1;
      }

      for (int i: count){
        if (i != 0) return false;
      }

      return true;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}