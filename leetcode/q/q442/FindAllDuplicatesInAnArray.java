/*
use negation to avoid extra space, two iteration will be enough
 */

package q.q442;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {
  public static void main(String[] args) {
    Solution solution = new FindAllDuplicatesInAnArray().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public List<Integer> findDuplicates(int[] nums) {

      ArrayList<Integer> res = new ArrayList<>();
      int q;
      for (int n: nums){
        q = Math.abs(n);
        if(nums[q-1] < 0) res.add(q);
        else nums[q-1] *= -1;
      }

      return res;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}