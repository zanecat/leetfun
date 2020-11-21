//Given two arrays, write a function to compute their intersection. 
//
// Example 1: 
//
// 
//Input: nums1 = [1,2,2,1], nums2 = [2,2]
//Output: [2,2]
// 
//
// 
// Example 2: 
//
// 
//Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//Output: [4,9] 
// 
//
// Note: 
//
// 
// Each element in the result should appear as many times as it shows in both ar
//rays. 
// The result can be in any order. 
// 
//
// Follow up: 
//
// 
// What if the given array is already sorted? How would you optimize your algori
//thm? 
// What if nums1's size is small compared to nums2's size? Which algorithm is be
//tter? 
// What if elements of nums2 are stored on disk, and the memory is limited such 
//that you cannot load all elements into the memory at once? 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 400 👎 0


package q.q350;

import java.util.Arrays;

public class IntersectionOfTwoArraysIi {
  public static void main(String[] args) {
    Solution solution = new IntersectionOfTwoArraysIi().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

      Arrays.sort(nums1);
      Arrays.sort(nums2);
      int length1 = nums1.length, length2 = nums2.length;
      int[] intersection = new int[Math.min(length1, length2)];
      int index1 = 0, index2 = 0, index = 0;
      while (index1 < length1 && index2 < length2) {
        if (nums1[index1] < nums2[index2]) {
          index1++;
        } else if (nums1[index1] > nums2[index2]) {
          index2++;
        } else {
          intersection[index] = nums1[index1];
          index1++;
          index2++;
          index++;
        }
      }
      return Arrays.copyOfRange(intersection, 0, index);
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}