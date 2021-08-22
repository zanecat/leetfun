//Given two strings s and t, determine if they are isomorphic. 
//
// Two strings s and t are isomorphic if the characters in s can be replaced to 
//get t. 
//
// All occurrences of a character must be replaced with another character while 
//preserving the order of characters. No two characters may map to the same charac
//ter, but a character may map to itself. 
//
// 
// Example 1: 
// Input: s = "egg", t = "add"
//Output: true
// Example 2: 
// Input: s = "foo", t = "bar"
//Output: false
// Example 3: 
// Input: s = "paper", t = "title"
//Output: true
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 5 * 104 
// t.length == s.length 
// s and t consist of any valid ascii character. 
// 
// Related Topics Hash Table String 
// 👍 2595 👎 543


package q.q205;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static void main(String[] args) {
        Solution solution = new IsomorphicStrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            return my(s).equals(my(t));
        }

        String my(String s){
            Map<Character, Integer> map = new HashMap<>();
            int i = 0;
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()){
                if (map.containsKey(c)){
                    sb.append(map.get(c)).append(",");
                } else {
                    map.put(c, i ++);
                    sb.append(i).append(',');
                }
            }

            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}