//Given a string, determine if it is a palindrome, considering only alphanumeric
// characters and ignoring cases. 
//
// Note: For the purpose of this problem, we define empty string as valid palind
//rome. 
//
// Example 1: 
//
// 
//Input: "A man, a plan, a canal: Panama"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: "race a car"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// s consists only of printable ASCII characters. 
// 
// Related Topics 双指针 字符串 
// 👍 282 👎 0


package q.q125
    ;

public class ValidPalindrome {
  public static void main(String[] args) {
    Solution solution = new ValidPalindrome().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean isPalindrome(String s) {

      int n = s.length();
      int left = 0, right = n - 1;
      while (left < right) {
        while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
          ++left;
        }
        while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
          --right;
        }
        if (left < right) {
          if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
            return false;
          }
          ++left;
          --right;
        }
      }
      return true;

    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}