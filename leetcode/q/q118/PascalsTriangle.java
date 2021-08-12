//Given a non-negative integer numRows, generate the first numRows of Pascal's t
//riangle. 
//
// 
//In Pascal's triangle, each number is the sum of the two numbers directly above
// it. 
//
// Example: 
//
// 
//Input: 5
//Output:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//]
// 
// Related Topics 数组 
// 👍 360 👎 0

/*
brute force...
 */
  
package q.q118;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PascalsTriangle{
  public static void main(String[] args) {
    Solution solution = new PascalsTriangle().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {

      List<List<Integer>> res = new ArrayList<>();
      res.add(List.of(1));
      for (int i = 2; i < numRows + 1; i ++){
        List<Integer> list = new LinkedList<>();
        List<Integer> last = res.get(res.size() - 1);

        list.add(1);
        for (int j = 1; j < i - 1; j ++){
          list.add(last.get(j - 1) + last.get(j));
        }
        list.add(1);
        res.add(list);
      }

      return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}