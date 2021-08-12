//Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal
//'s triangle. 
//
// In Pascal's triangle, each number is the sum of the two numbers directly abov
//e it as shown: 
//
// 
// Example 1: 
// Input: rowIndex = 3
//Output: [1,3,3,1]
// Example 2: 
// Input: rowIndex = 0
//Output: [1]
// Example 3: 
// Input: rowIndex = 1
//Output: [1,1]
// 
// 
// Constraints: 
//
// 
// 0 <= rowIndex <= 33 
// 
//
// 
// Follow up: Could you optimize your algorithm to use only O(rowIndex) extra sp
//ace? 
// Related Topics Array Dynamic Programming 
// 👍 1623 👎 232

  
  package q.q119;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PascalsTriangleIi{
      public static void main(String[] args) {
           Solution solution = new PascalsTriangleIi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 2; i < rowIndex + 2; i ++){
            List<Integer> list = new LinkedList<>();

            list.add(1);
            for (int j = 1; j < i - 1; j ++){
                list.add(res.get(j - 1) + res.get(j));
            }
            list.add(1);
            res= (list);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }