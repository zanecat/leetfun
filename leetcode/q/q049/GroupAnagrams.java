//Given an array of strings strs, group the anagrams together. You can return th
//e answer in any order. 
//
// An Anagram is a word or phrase formed by rearranging the letters of a differe
//nt word or phrase, typically using all the original letters exactly once. 
//
// 
// Example 1: 
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
// Example 2: 
// Input: strs = [""]
//Output: [[""]]
// Example 3: 
// Input: strs = ["a"]
//Output: [["a"]]
// 
// 
// Constraints: 
//
// 
// 1 <= strs.length <= 104 
// 0 <= strs[i].length <= 100 
// strs[i] consists of lower-case English letters. 
// 
// Related Topics 哈希表 字符串 
// 👍 487 👎 0

  
package q.q049;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams{
  public static void main(String[] args) {
    Solution solution = new GroupAnagrams().new Solution();
    System.out.println(solution.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

      HashMap<String, List<String>> count = new HashMap<>();
      char [] temp;
      List<String> tempList;
      for (String s: strs){
        temp = s.toCharArray();
        Arrays.sort(temp);

        tempList = count.getOrDefault(new String(temp), new ArrayList<>());
        tempList.add(s);
        count.put(new String(temp), tempList);
      }

      return new ArrayList<>(count.values()) ;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}