//Given an array nums with n integers, your task is to check if it could become 
//non-decreasing by modifying at most 1 element. 
//
// We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for ever
//y i (0-based) such that (0 <= i <= n - 2). 
//
// 
// Example 1: 
//
// 
//Input: nums = [4,2,3]
//Output: true
//Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
// 
//
// Example 2: 
//
// 
//Input: nums = [4,2,1]
//Output: false
//Explanation: You can't get a non-decreasing array by modify at most one elemen
//t.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10 ^ 4 
// - 10 ^ 5 <= nums[i] <= 10 ^ 5 
// 
// Related Topics 数组 
// 👍 354 👎 0


package q.q665;

public class NonDecreasingArray {
  public static void main(String[] args) {
    Solution solution = new NonDecreasingArray().new Solution();
    System.out.println(solution.checkPossibility(new int[] {10,1,3,4}));
    ;
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean checkPossibility(int[] nums) {
      if(nums.length < 3){
        return true;
      }
      int count = 0;
      for(int i=0;i<nums.length-1;i++){
        if(nums[i] > nums[i+1]){
          count++;
          if(count > 1){
            break;
          }
          if(i-1 >=0&&nums[i-1] > nums[i+1]){
            nums[i+1] = nums[i];
          }else{
            nums[i] = nums[i+1];
          }
        }
      }
      return count <= 1;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}