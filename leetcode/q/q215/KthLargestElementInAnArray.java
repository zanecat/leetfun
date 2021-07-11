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
        Solution solution = new KthLargestElementInAnArray().new Solution();
        var nums = new int[]{3,6,3,5,5,2,1,3};
        solution.qss(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Random random = new Random();
        public int findKthLargest(int[] nums, int k) {
            int l = 0, r = nums.length - 1;

            int start = qs(nums, l, r);;

            while (start != nums.length - k) {


                if (start == nums.length - k) {
                    return nums[start];
                }
                if (start > nums.length - k) {
                    r = start - 1;
                    start = qs(nums, l, r);
                } else {
                    l = start + 1;
                    start = qs(nums, l, r);
                }
            }

            return nums[start];
        }

        void swap(int[] nums, int l, int r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }

        int qs(int[] nums, int l, int r) {
            randomize(nums, l, r);
            int pivot = nums[l];
            while (l < r) {
                while (l < r && nums[r] >= pivot) {
                    r--;
                }
                swap(nums, l, r);
                while (l < r && nums[l] <= pivot) {
                    l++;
                }
                swap(nums, l, r);

            }

            return l;
        }

        void randomize(int [] nums, int l, int r){
            int i = random.nextInt(r - l + 1) + l ;
            swap(nums, l, i);
        }

        void qss(int[] nums, int l, int r) {
            if(l>=r){
                return;
            }
            int pivot = nums[l];
            int ll = l;
            int rr = r;
            while (ll < rr) {
                while (ll < rr && nums[rr] >= pivot) {
                    rr--;
                }
                swap(nums, ll, rr);
                while (ll < rr && nums[ll] <= pivot) {
                    ll++;
                }
                swap(nums, ll, rr);

            }

            qss(nums, l, ll -1);
            qss(nums, ll + 1, r);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}