//Write a function to find the longest common prefix string amongst an array of 
//strings. 
//
// If there is no common prefix, return an empty string "". 
//
// 
// Example 1: 
//
// 
//Input: strs = ["flower","flow","flight"]
//Output: "fl"
// 
//
// Example 2: 
//
// 
//Input: strs = ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.
// 
//
// 
// Constraints: 
//
// 
// 0 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] consists of only lower-case English letters. 
// 
// Related Topics 字符串 
// 👍 1306 👎 0

  
package q.q014;
  
public class LongestCommonPrefix{
  public static void main(String[] args) {
    Solution solution = new LongestCommonPrefix().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
      if (strs == null || strs.length == 0) {
        return "";
      }
      int minLength = Integer.MAX_VALUE;
      for (String str : strs) {
        minLength = Math.min(minLength, str.length());
      }
      int low = 0, high = minLength;
      while (low < high) {
        int mid = (high - low + 1) / 2 + low;
        if (isCommonPrefix(strs, mid)) {
          low = mid;
        } else {
          high = mid - 1;
        }
      }
      return strs[0].substring(0, low);
    }

    boolean isCommonPrefix(String[] strs, int length) {
      String str0 = strs[0].substring(0, length);
      int count = strs.length;
      for (int i = 1; i < count; i++) {
        String str = strs[i];
        for (int j = 0; j < length; j++) {
          if (str0.charAt(j) != str.charAt(j)) {
            return false;
          }
        }
      }
      return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}