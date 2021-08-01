//Given a list of non-negative integers nums, arrange them such that they form t
//he largest number. 
//
// Note: The result may be very large, so you need to return a string instead of
// an integer. 
//
// 
// Example 1: 
//
// 
//Input: nums = [10,2]
//Output: "210"
// 
//
// Example 2: 
//
// 
//Input: nums = [3,30,34,5,9]
//Output: "9534330"
// 
//
// Example 3: 
//
// 
//Input: nums = [1]
//Output: "1"
// 
//
// Example 4: 
//
// 
//Input: nums = [10]
//Output: "10"
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 109 
// 
// Related Topics String Greedy Sorting 
// 👍 3486 👎 337


package q.q179;

import java.util.Arrays;

public class LargestNumber {
    public static void main(String[] args) {
        Solution solution = new LargestNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestNumber(int[] nums) {
            String[] strings = new String[nums.length];

            for (int i = 0; i < nums.length; i ++){
                strings[i] = "" + nums[i];
            }

            Arrays.sort(strings, (String s1, String s2) -> {
                String sum1 = s1 + s2;
                String sum2 = s2 + s1;
                return sum2.compareTo(sum1);
            });

            StringBuilder sb = new StringBuilder();

            int i = 0;
            while (i < strings.length && strings[i].equals("0")){
                i ++;
            }

            if (i == strings.length) return "0";

            for (int j = i; j < strings.length; j ++){
                sb.append(strings[j]);
            }

            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}