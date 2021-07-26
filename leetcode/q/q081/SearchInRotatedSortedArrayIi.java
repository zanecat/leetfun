//There is an integer array nums sorted in non-decreasing order (not necessarily
// with distinct values). 
//
// Before being passed to your function, nums is rotated at an unknown pivot ind
//ex k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1]
//, ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0
//,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,
//2,4,4]. 
//
// Given the array nums after the rotation and an integer target, return true if
// target is in nums, or false if it is not in nums. 
//
// You must decrease the overall operation steps as much as possible. 
//
// 
// Example 1: 
// Input: nums = [2,5,6,0,0,1,2], target = 0
//Output: true
// Example 2: 
// Input: nums = [2,5,6,0,0,1,2], target = 3
//Output: false
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// -104 <= nums[i] <= 104 
// nums is guaranteed to be rotated at some pivot. 
// -104 <= target <= 104 
// 
//
// 
// Follow up: This problem is similar to Search in Rotated Sorted Array, but num
//s may contain duplicates. Would this affect the runtime complexity? How and why?
// 
// Related Topics Array Binary Search 
// 👍 2436 👎 605


package q.q081;

public class SearchInRotatedSortedArrayIi {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArrayIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean search(int[] nums, int target) {
            return bi(nums, target, 0, nums.length - 1);
        }

        boolean bi(int [] nums, int tar, int l, int r){
            if (l > r ) return false;
            if (l == r) return nums[l] == tar;

            int mid = l + (r - l)/2;

            if (nums[mid] == tar) return true;
            if (nums[l] == nums[mid] && nums[r] == nums[mid]) return bi(nums, tar, l + 1, r - 1);

            if (nums[l] <= nums[mid]){
                if (tar >= nums[l] && tar < nums[mid]) return bi(nums, tar, l, mid - 1);
                else return bi(nums, tar, mid + 1, r);
            } else {
                if (tar > nums[mid] && tar <= nums[r]) return bi(nums, tar, mid + 1, r);
                else return bi(nums, tar, l, mid - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}