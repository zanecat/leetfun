//Given an array of integers nums sorted in ascending order, find the starting a
//nd ending position of a given target value. 
//
// If target is not found in the array, return [-1, -1]. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
// Example 2: 
// Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
// Example 3: 
// Input: nums = [], target = 0
//Output: [-1,-1]
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums is a non-decreasing array. 
// -109 <= target <= 109 
// 
// Related Topics Array Binary Search 
// 👍 6286 👎 215


package q.q034;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int [] nums;
        int len;
        int target;
        public int[] searchRange(int[] nums, int target) {
            this.nums = nums;
            len = nums.length;
            this.target =  target;

            if (len == 0) return new int[]{-1, -1};
            int ll = 0, rr = len - 1;

            int left = findL(0, len -1);
            int ri = findR(0, len - 1);
            return new int[]{left, ri};
        }

        int findL(int l, int r){
            if (l > r) return -1;
            int mi = l + (r - l)/2;

            if (nums[mi] == target){
                if (mi == 0){
                    return 0;
                } else if (nums[mi - 1] != target){
                    return mi;
                }
            }

            if (nums[mi] >= target){
                return findL(l, mi - 1);
            } else {
                return findL(mi + 1, r);
            }
        }

        int findR(int l, int r){
            if (l > r) return -1;
            int mi = l + (r - l)/2;

            if (nums[mi] == target){
                if (mi == len - 1){
                    return len - 1;
                } else if (nums[mi + 1] != target){
                    return mi;
                }
            }

            if (nums[mi] > target){
                return findR(l, mi - 1);
            } else {
                return findR(mi + 1, r);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}