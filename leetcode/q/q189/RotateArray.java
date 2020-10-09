//Given an array, rotate the array to the right by k steps, where k is non-negat
//ive. 
//
// Follow up: 
//
// 
// Try to come up as many solutions as you can, there are at least 3 different w
//ays to solve this problem. 
// Could you do it in-place with O(1) extra space? 
// 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,4,5,6,7], k = 3
//Output: [5,6,7,1,2,3,4]
//Explanation:
//rotate 1 steps to the right: [7,1,2,3,4,5,6]
//rotate 2 steps to the right: [6,7,1,2,3,4,5]
//rotate 3 steps to the right: [5,6,7,1,2,3,4]
// 
//
// Example 2: 
//
// 
//Input: nums = [-1,-100,3,99], k = 2
//Output: [3,99,-1,-100]
//Explanation: 
//rotate 1 steps to the right: [99,-1,-100,3]
//rotate 2 steps to the right: [3,99,-1,-100]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 104 
// -231 <= nums[i] <= 231 - 1 
// 0 <= k <= 105 
// 
// Related Topics 数组 
// 👍 710 👎 0


package q.q189;

public class RotateArray {
  public static void main(String[] args) {
    Solution solution = new RotateArray().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public void rotate(int[] nums, int k) {
      int len = nums.length;

      if(len <= 1) return;
      if(k%len == 0) return;

      int [] res = new int[len];
      int dest = 0;
      for (int i = 0; i < len; i++){
        dest = (i + k)%len;
        res[dest] = nums[i];
      }

      System.arraycopy(res, 0, nums, 0, len);
    }

    // use O(1) space
    public void rotate2(int[] nums, int k){
      int len = nums.length;

      if(len <= 1) return;
      if(k%len == 0) return;
      int temp1 = nums[0], temp2;

      while (k-- > 0) {
        for (int i = 1; i < len; i++) {
          temp2 = nums[i];
          nums[i] = temp1;
          temp1 = temp2;
        }

        nums[0] = temp1;
      }
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}