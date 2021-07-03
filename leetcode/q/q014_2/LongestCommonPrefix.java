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
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] consists of only lower-case English letters. 
// 
// Related Topics String 
// 👍 4559 👎 2313


package q.q014_2;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) return "";
            String common = strs[0];
            for (int i = 1; i < strs.length; i ++){
                int l = 0;
                for (int j = 0; j < common.length() && j < strs[i].length(); j ++){
                    if (strs[i].charAt(j) == common.charAt(j)){
                        l++;
                    } else {
                        break;
                    }
                }
                if (l > 0) {
                    common = common.substring(0, l);
                } else {
                    return "";
                }
            }
            return common;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}