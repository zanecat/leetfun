//The set [1, 2, 3, ..., n] contains a total of n! unique permutations. 
//
// By listing and labeling all of the permutations in order, we get the followin
//g sequence for n = 3: 
//
// 
// "123" 
// "132" 
// "213" 
// "231" 
// "312" 
// "321" 
// 
//
// Given n and k, return the kth permutation sequence. 
//
// 
// Example 1: 
// Input: n = 3, k = 3
//Output: "213"
// Example 2: 
// Input: n = 4, k = 9
//Output: "2314"
// Example 3: 
// Input: n = 3, k = 1
//Output: "123"
// 
// 
// Constraints: 
//
// 
// 1 <= n <= 9 
// 1 <= k <= n! 
// 
// Related Topics Math Recursion 
// 👍 2723 👎 376


package q.q060;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    public static void main(String[] args) {
        Solution solution = new PermutationSequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String getPermutation(int n, int k) {
            k--;

            int [] fac = new int [n];
            fac[0] = 1;
            for(int i = 1; i < n ; i ++){
                fac[i] = i * fac[i - 1];
            }

            List<Integer> nums = new ArrayList<>();

            for(int i = 1; i <= n; i ++){
                nums.add(i);
            }

            StringBuilder sb = new StringBuilder();
            int i = n - 1;
            while(i >= 0){
                int j = k/fac[i];
                sb.append(nums.remove(j));
                k -= j * fac[i--];
            }

            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}