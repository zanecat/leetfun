//Given an integer array nums and an integer k, return the kth largest element i
//n the array. 
//
// Note that it is the kth largest element in the sorted order, not the kth dist
//inct element. 
//
// 
// Example 1: 
// Input: nums = [3,2,1,5,6,4], k = 2
//Output: 5
// Example 2: 
// Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
//Output: 4
// 
// 
// Constraints: 
//
// 
// 1 <= k <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// 
// Related Topics Array Divide and Conquer Sorting Heap (Priority Queue) Quickse
//lect 
// 👍 6175 👎 380


package q.q215;

import java.util.Arrays;
import java.util.Random;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Random random = new Random();
        public int findKthLargest(int[] nums, int k) {
            return qs(nums, 0, nums.length - 1, k - 1);
        }

        int qs(int [] nums, int l, int r, int k){
            int rand = random.nextInt(r - l + 1) + l;
            swap(nums, l, rand);
            int pivot = nums[l];
            int ll = l;
            int rr = r;

            while (ll < rr){
                while (ll < rr && nums[rr] <= pivot){
                    rr --;
                }
                swap(nums, ll, rr);
                while (ll < rr && nums[ll] >= pivot){
                    ll ++;
                }
                swap(nums, ll, rr);
            }

            if (ll == k ) return nums[ll];
            if (ll > k){
                return qs(nums, l, ll - 1, k);
            } else {
                return qs(nums, ll + 1, r, k);
            }
        }

        void swap(int [] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}