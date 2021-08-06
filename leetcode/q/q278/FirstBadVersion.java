//You are a product manager and currently leading a team to develop a new produc
//t. Unfortunately, the latest version of your product fails the quality check. Si
//nce each version is developed based on the previous version, all the versions af
//ter a bad version are also bad. 
//
// Suppose you have n versions [1, 2, ..., n] and you want to find out the first
// bad one, which causes all the following ones to be bad. 
//
// You are given an API bool isBadVersion(version) which returns whether version
// is bad. Implement a function to find the first bad version. You should minimize
// the number of calls to the API. 
//
// 
// Example 1: 
//
// 
//Input: n = 5, bad = 4
//Output: 4
//Explanation:
//call isBadVersion(3) -> false
//call isBadVersion(5) -> true
//call isBadVersion(4) -> true
//Then 4 is the first bad version.
// 
//
// Example 2: 
//
// 
//Input: n = 1, bad = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= bad <= n <= 231 - 1 
// 
// Related Topics Binary Search Interactive 
// 👍 2514 👎 906


package q.q278;

public class FirstBadVersion {
    public static void main(String[] args) {
        Solution solution = new FirstBadVersion().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

    public class Solution {
        public int firstBadVersion(int n) {
            if (n == 1) return 1;

            int l = 0, r= n;

            while (l < r){
                int mid = l + (r - l)/2;

                if (isBadVersion(mid)){
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }

            return l;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    boolean isBadVersion(int n){ return true; }

}