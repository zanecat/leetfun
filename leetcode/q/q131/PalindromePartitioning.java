//Given a string s, partition s such that every substring of the partition is a 
//palindrome. Return all possible palindrome partitioning of s. 
//
// A palindrome string is a string that reads the same backward as forward. 
//
// 
// Example 1: 
// Input: s = "aab"
//Output: [["a","a","b"],["aa","b"]]
// Example 2: 
// Input: s = "a"
//Output: [["a"]]
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 16 
// s contains only lowercase English letters. 
// 
// Related Topics String Dynamic Programming Backtracking 
// 👍 4035 👎 126


package q.q131;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioning().new Solution();
        solution.partition("aab");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> res = new LinkedList<>();
        String s;
        int [][] f;

        public List<List<String>> partition(String s) {
            this.s = s;
            char[] chars = s.toCharArray();
            f = new int[chars.length][chars.length];

            bt(chars, 0, new LinkedList<>());
            return res;
        }

        void bt(char[] chars, int start, List<String> ll) {
            if (start == chars.length){
                res.add(new ArrayList<>(ll));
                return;
            }

            for (int i = start; i < chars.length; i ++){
                if (isPalind(chars, start, i)){
                    ll.add(s.substring(start, i+ 1));
                    bt(chars, i + 1, ll);
                    ll.remove(ll.size() - 1);
                }
            }
        }

        boolean isPalind(char[] chars, int i, int j){
            if (f[i][j] != 0) {
                return f[i][j] == 1;
            }
            if (i >= j) {
                f[i][j] = 1;
            } else if (s.charAt(i) == s.charAt(j)) {
                f[i][j] = isPalind(chars, i + 1, j - 1) ? 1 : -1;
            } else {
                f[i][j] = -1;
            }
            return f[i][j] == 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}