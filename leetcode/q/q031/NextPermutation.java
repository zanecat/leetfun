//Implement next permutation, which rearranges numbers into the lexicographicall
//y next greater permutation of numbers. 
//
// If such an arrangement is not possible, it must rearrange it as the lowest po
//ssible order (i.e., sorted in ascending order). 
//
// The replacement must be in place and use only constant extra memory. 
//
// 
// Example 1: 
// Input: nums = [1,2,3]
//Output: [1,3,2]
// Example 2: 
// Input: nums = [3,2,1]
//Output: [1,2,3]
// Example 3: 
// Input: nums = [1,1,5]
//Output: [1,5,1]
// Example 4: 
// Input: nums = [1]
//Output: [1]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics Array Two Pointers 
// 👍 7037 👎 2296


package q.q031;

public class NextPermutation {
    public static void main(String[] args) {
        Solution solution = new NextPermutation().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            int n = nums.length;
            int i = n - 2, j = n - 1, k = n - 1;

            while (i >= 0 && nums[i] >= nums[j]){
                i -- ;
                j -- ;
            }

            if (i >= 0){
                while (nums[k] <= nums[i]){
                    k --;
                }

                swap(nums, i, k);
            }

            int l = n - 1;

            while (j < l){
                swap(nums, j, l);
                j ++;
                l --;
            }
        }

        void swap(int[] nums, int l, int r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}