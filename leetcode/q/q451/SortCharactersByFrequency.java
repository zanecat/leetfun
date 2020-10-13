//Given a string, sort it in decreasing order based on the frequency of characte
//rs. 
//
// Example 1:
// 
//Input:
//"tree"
//
//Output:
//"eert"
//
//Explanation:
//'e' appears twice while 'r' and 't' both appear once.
//So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid a
//nswer.
// 
// 
//
// Example 2:
// 
//Input:
//"cccaaa"
//
//Output:
//"cccaaa"
//
//Explanation:
//Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
//Note that "cacaca" is incorrect, as the same characters must be together.
// 
// 
//
// Example 3:
// 
//Input:
//"Aabb"
//
//Output:
//"bbAa"
//
//Explanation:
//"bbaA" is also a valid answer, but "Aabb" is incorrect.
//Note that 'A' and 'a' are treated as two different characters.
// 
// Related Topics 堆 哈希表 
// 👍 171 👎 0


package q.q451;

import java.util.PriorityQueue;

public class SortCharactersByFrequency {
  public static void main(String[] args) {
    Solution solution = new SortCharactersByFrequency().new Solution();
    solution.frequencySort("raaeaedere");
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public String frequencySort(String s) {
      int [] count = new int[128];

      for (char c: s.toCharArray()){
        count[c]++;
      }

      PriorityQueue<Character> heap = new PriorityQueue<>(128, (a, b) -> Integer.compare(count[b] , count[a]));

      for (int i = 0; i < count.length; ++i) {
        if (count[i] != 0) {
          heap.offer((char) (i));
        }
      }


      StringBuffer stringBuffer = new StringBuffer();
      char tmp;
      while (!heap.isEmpty()){
        tmp = heap.poll();
        while (count[tmp]-- > 0){
          stringBuffer.append(tmp);
        }
      }

      return stringBuffer.toString();


    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}