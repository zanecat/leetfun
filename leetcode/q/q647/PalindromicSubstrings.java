//Given a string s, return the number of palindromic substrings in it. 
//
// A string is a palindrome when it reads the same backward as forward. 
//
// A substring is a contiguous sequence of characters within the string. 
//
// 
// Example 1: 
//
// 
//Input: s = "abc"
//Output: 3
//Explanation: Three palindromic strings: "a", "b", "c".
// 
//
// Example 2: 
//
// 
//Input: s = "aaa"
//Output: 6
//Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consists of lowercase English letters. 
// 
// Related Topics String Dynamic Programming 
// 👍 4649 👎 141


package q.q647;

import java.util.ArrayList;
import java.util.List;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        Solution solution = new PalindromicSubstrings().new Solution();
        solution.countSubstrings("aaa");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubstrings(String s) {
            List<int[]> pos = new ArrayList<>();
            var chars = s.toCharArray();
            int n = s.length();
            int res = 0;
            for (int i = 0; i < n; i ++){
                pos.add(new int[]{i, i});
                if (i < n - 1 && chars[i] == chars[i + 1]) pos.add(new int[]{i, i + 1});
            }

            res += pos.size();

            boolean updated = true;
            while (updated){
                List<int []> newPos = new ArrayList<>();
                for (int [] p : pos){
                    updated = false;
                    if (p[0] - 1 >= 0 && p[1] + 1 <= n - 1 && chars[p[0] - 1] == chars[p[1] +1]){
                        newPos.add(new int[]{p[0] - 1, p[1] + 1});
                    }


                }

                if (newPos.size() > 0){
                    updated = true;
                }

                pos = newPos;
                res += pos.size();
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}