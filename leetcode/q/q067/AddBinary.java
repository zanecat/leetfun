//Given two binary strings a and b, return their sum as a binary string. 
//
// 
// Example 1: 
// Input: a = "11", b = "1"
//Output: "100"
// Example 2: 
// Input: a = "1010", b = "1011"
//Output: "10101"
// 
// 
// Constraints: 
//
// 
// 1 <= a.length, b.length <= 104 
// a and b consist only of '0' or '1' characters. 
// Each string does not contain leading zeros except for the zero itself. 
// 
// Related Topics Math String Bit Manipulation Simulation 
// 👍 3223 👎 384

  
  package q.q067;
  public class AddBinary{
      public static void main(String[] args) {
           Solution solution = new AddBinary().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for(int i = a.length() - 1, j = b.length() - 1;i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2);
            ca = sum / 2;
        }
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }