//Given an array nums of n integers where nums[i] is in the range [1, n], return
// an array of all the integers in the range [1, n] that do not appear in nums. 
//
// 
// Example 1: 
// Input: nums = [4,3,2,7,8,2,3,1]
//Output: [5,6]
// Example 2: 
// Input: nums = [1,1]
//Output: [2]
// 
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 105 
// 1 <= nums[i] <= n 
// 
//
// 
// Follow up: Could you do it without extra space and in O(n) runtime? You may a
//ssume the returned list does not count as extra space. 
// Related Topics Array Hash Table 
// 👍 4505 👎 313


package q.q448_2;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        Solution solution = new FindAllNumbersDisappearedInAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            var ll = new ArrayList<Integer>();
            int len = nums.length + 1;
            for (int n : nums){
                int i = n%len;
                nums[i - 1] += len;
            }

            for (int i = 0; i < len - 1; i ++){
                if (nums[i] <= len){
                    ll.add(i + 1);
                }
            }

            return ll;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}