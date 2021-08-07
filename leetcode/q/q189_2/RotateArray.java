//Given an array, rotate the array to the right by k steps, where k is non-negat
//ive. 
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
// 1 <= nums.length <= 105 
// -231 <= nums[i] <= 231 - 1 
// 0 <= k <= 105 
// 
//
// 
// Follow up: 
//
// 
// Try to come up with as many solutions as you can. There are at least three di
//fferent ways to solve this problem. 
// Could you do it in-place with O(1) extra space? 
// 
// Related Topics Array Math Two Pointers 
// 👍 5234 👎 972


package q.q189_2;

public class RotateArray {
    public static void main(String[] args) {
        Solution solution = new RotateArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[] nums, int k) {
            int nk = k % nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, nk -1);
            reverse(nums, nk, nums.length - 1);

        }

        void reverse(int [] nums, int s, int e){
            int l = s, r = e;

            while (l < r){
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;

                l ++;
                r --;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}