//
//Given a string and an integer k, you need to reverse the first k characters fo
//r every 2k characters counting from the start of the string. If there are less t
//han k characters left, reverse all of them. If there are less than 2k but greate
//r than or equal to k characters, then reverse the first k characters and left th
//e other as original.
// 
//
// Example: 
// 
//Input: s = "abcdefg", k = 2
//Output: "bacdfeg"
// 
// 
//
//Restrictions: 
// 
// The string consists of lower English letters only. 
// Length of the given string and k will in the range [1, 10000] 
// Related Topics 字符串 
// 👍 97 👎 0


package q.q541;

public class ReverseStringIi {
  public static void main(String[] args) {
    Solution solution = new ReverseStringIi().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public String reverseStr(String s, int k) {

      char[] a = s.toCharArray();
      for (int start = 0; start < a.length; start += 2 * k) {
        int i = start, j = Math.min(start + k - 1, a.length - 1);
        while (i < j) {
          char tmp = a[i];
          a[i++] = a[j];
          a[j--] = tmp;
        }
      }
      return new String(a);
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}