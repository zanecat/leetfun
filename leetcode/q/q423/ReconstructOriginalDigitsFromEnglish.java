//Given a non-empty string containing an out-of-order English representation of 
//digits 0-9, output the digits in ascending order. 
//
// Note: 
// 
// Input contains only lowercase English letters. 
// Input is guaranteed to be valid and can be transformed to its original digits
//. That means invalid inputs such as "abc" or "zerone" are not permitted. 
// Input length is less than 50,000. 
// 
// 
//
// Example 1: 
// 
//Input: "owoztneoer"
//
//Output: "012"
// 
// 
//
// Example 2: 
// 
//Input: "fviefuro"
//
//Output: "45"
// 
// Related Topics 数学 
// 👍 51 👎 0


package q.q423;

public class ReconstructOriginalDigitsFromEnglish {
  public static void main(String[] args) {
    Solution solution = new ReconstructOriginalDigitsFromEnglish().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public String originalDigits(String s) {

      int[] count = new int[128];
      for (char c : s.toCharArray()) count[c]++;

      int[] nums = new int[10];

      nums[0] = count['z'];
      nums[6] = count['x'];
      nums[7] = count['s'] - nums[6];
      nums[5] = count['v'] - nums[7];
      nums[2] = count['w'];
      nums[4] = count['u'];
      nums[8] = count['g'];
      nums[3] = count['h'] - nums[8];
      nums[1] = count['o'] - nums[2] - nums[0] - nums[4];
      nums[9] = count['i'] - nums[8] - nums[6] - nums[5];

      StringBuffer sb = new StringBuffer();

      for (int i = 0; i < 10; i ++){
        while (nums[i] -- > 0){
          sb.append(i);
        }
      }

      return sb.toString();
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}