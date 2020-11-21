/*
because A[i] is in (1, n), to just iterate 1..n and use negation to mark the occurrence
 */

package q.q448;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        Solution solution = new FindAllNumbersDisappearedInAnArray().new Solution();
        System.out.println(solution.findDisappearedNumbers(new int[] {4,3,2,7,8,2,3,1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> res = new ArrayList<>();
            int len = nums.length;
            for(int i = 0; i < len; i++){
                int num = Math.abs(nums[i]);
                int index = num - 1;
                if(nums[index] > 0){
                    nums[index] *= -1;
                }
            }
            for(int i = 0; i < len; i++){
                if(nums[i] > 0){
                    int num = i + 1;
                    res.add(num);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}