//Write a function that reverses a string. The input string is given as an array
// of characters s. 
//
// 
// Example 1: 
// Input: s = ["h","e","l","l","o"]
//Output: ["o","l","l","e","h"]
// Example 2: 
// Input: s = ["H","a","n","n","a","h"]
//Output: ["h","a","n","n","a","H"]
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 105 
// s[i] is a printable ascii character. 
// 
//
// 
// Follow up: Do not allocate extra space for another array. You must do this by
// modifying the input array in-place with O(1) extra memory. 
// Related Topics Two Pointers String Recursion 
// 👍 2788 👎 818

  
  package q.q344;
  public class ReverseString{
      public static void main(String[] args) {
           Solution solution = new ReverseString().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          public void reverseString(char[] s) {
              int l = 0, r = s.length - 1;
              while(l < r){
                  swap(s, l, r);
                  l ++;
                  r --;
              }
          }

          void swap(char[] s, int i, int j){
              char temp = s[i];
              s[i] = s[j];
              s[j] = temp;
          }
}
//leetcode submit region end(Prohibit modification and deletion)

  }