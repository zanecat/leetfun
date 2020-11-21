//Given a string, find the first non-repeating character in it and return its in
//dex. If it doesn't exist, return -1. 
//
// Examples: 
//
// 
//s = "leetcode"
//return 0.
//
//s = "loveleetcode"
//return 2.
// 
//
// 
//
// Note: You may assume the string contains only lowercase English letters. 
// Related Topics 哈希表 字符串 
// 👍 274 👎 0


package q.q387;

import java.util.HashMap;

public class FirstUniqueCharacterInAString {
  public static void main(String[] args) {
    Solution solution = new FirstUniqueCharacterInAString().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int firstUniqChar(String s) {
      HashMap<Character, Integer> count = new HashMap<Character, Integer>();
      int n = s.length();
      for (int i = 0; i < n; i++) {
        char c = s.charAt(i);
        count.put(c, count.getOrDefault(c, 0) + 1);
      }
      for (int i = 0; i < n; i++) {
        if (count.get(s.charAt(i)) == 1)
          return i;
      }
      return -1;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}