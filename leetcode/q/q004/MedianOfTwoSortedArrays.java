//Given two sorted arrays nums1 and nums2 of size m and n respectively, return t
//he median of the two sorted arrays. 
//
// The overall run time complexity should be O(log (m+n)). 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,3], nums2 = [2]
//Output: 2.00000
//Explanation: merged array = [1,2,3] and median is 2.
// 
//
// Example 2: 
//
// 
//Input: nums1 = [1,2], nums2 = [3,4]
//Output: 2.50000
//Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
// 
//
// Example 3: 
//
// 
//Input: nums1 = [0,0], nums2 = [0,0]
//Output: 0.00000
// 
//
// Example 4: 
//
// 
//Input: nums1 = [], nums2 = [1]
//Output: 1.00000
// 
//
// Example 5: 
//
// 
//Input: nums1 = [2], nums2 = []
//Output: 2.00000
// 
//
// 
// Constraints: 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
// Related Topics Array Binary Search Divide and Conquer 
// 👍 11747 👎 1636


package q.q004;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3,4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int n1 = nums1.length, n2 = nums2.length, k1 = (n1 + n2 + 1)/2, k2 = (n1 + n2 + 2)/2;

            int l = getK(nums1, nums2, k1, 0, 0);
            int r = k1 == k2 ? l : getK(nums1, nums2, k2, 0, 0);
            return (l + r)/2.0;
        }

        int getK(int[] nums1, int[] nums2, int k, int s1, int s2){
            int n1 = nums1.length, n2 = nums2.length;
            if (n1 == s1) return nums2[s2 + k - 1];
            if (n2 == s2) return nums1[s1 + k - 1];
            if (k == 1) return Math.min(nums1[s1], nums2[s2]);

            int half = k/2;

            int ss1 = Math.min(n1 - 1, s1 + half - 1);
            int ss2 = Math.min(n2 - 1, s2 + half - 1);

            if (nums1[ss1] < nums2[ss2]){
                return getK(nums1, nums2, k - (ss1 - s1 + 1), ss1 + 1, s2);
            }

            return getK(nums1, nums2, k - (ss2 - s2 + 1), s1, ss2 + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}