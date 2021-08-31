//Given a string s and a dictionary of strings wordDict, add spaces in s to cons
//truct a sentence where each word is a valid dictionary word. Return all such pos
//sible sentences in any order. 
//
// Note that the same word in the dictionary may be reused multiple times in the
// segmentation. 
//
// 
// Example 1: 
//
// 
//Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
//Output: ["cats and dog","cat sand dog"]
// 
//
// Example 2: 
//
// 
//Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","p
//ineapple"]
//Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
//Explanation: Note that you are allowed to reuse a dictionary word.
// 
//
// Example 3: 
//
// 
//Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//Output: []
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 20 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 10 
// s and wordDict[i] consist of only lowercase English letters. 
// All the strings of wordDict are unique. 
// 
// Related Topics Hash Table String Dynamic Programming Backtracking Trie Memoiz
//ation 
// 👍 3692 👎 453


package q.q140;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakIi {
    public static void main(String[] args) {
        Solution solution = new WordBreakIi().new Solution();
        solution.wordBreak("catsanddog", List.of("cat", "cats", "and", "sand", "dog"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Set<String> words = new HashSet<>();
        public List<String> wordBreak(String s, List<String> wordDict) {
            words.addAll(wordDict);

            return my(s);
        }

        List<String> my(String s){
            List<String> res = new ArrayList<>();
            if (s.equals("")) return res;
            for (int i = s.length() - 1; i >= 0; i --){
                String temp = s.substring(i);
                if (words.contains(temp)){
                    if (i == 0){
                        res.add(s);
                    } else {
                        var po = my(s.substring(0, i));
                        for (String p : po){
                            res.add(p + " " + temp);
                        }
                    }

                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}