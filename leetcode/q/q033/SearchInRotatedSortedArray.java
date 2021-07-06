//There is an integer array nums sorted in ascending order (with distinct values
//). 
//
// Prior to being passed to your function, nums is rotated at an unknown pivot i
//ndex k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+
//1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, 
//[0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2]. 
//
// Given the array nums after the rotation and an integer target, return the ind
//ex of target if it is in nums, or -1 if it is not in nums. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
// Example 2: 
// Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1
// Example 3: 
// Input: nums = [1], target = 0
//Output: -1
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// -104 <= nums[i] <= 104 
// All values of nums are unique. 
// nums is guaranteed to be rotated at some pivot. 
// -104 <= target <= 104 
// 
// Related Topics Array Binary Search 
// 👍 8470 👎 701


package q.q033;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            return mySearch(nums, target, 0, nums.length - 1);
        }

        int mySearch(int[] nums, int target, int l, int r){
            if (l == r) return nums[l] == target ? l : -1;
            int mid = l + (r - l)/2;

            if (nums[mid] == target) return mid;

            if (nums[l] <= nums[mid]){
                if(nums[l] <= target && nums[mid] > target){
                    return mySearch(nums, target, l, mid);
                } else return mySearch(nums, target, mid + 1, r);
            }

            if (nums[mid + 1] <= nums[r]){
                if (nums[mid + 1] <= target && nums[r] >= target){
                    return mySearch(nums, target, mid + 1, r);
                } else {
                    return mySearch(nums, target, l, mid);
                }
            }

            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}