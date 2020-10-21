/*
We only need to look at all positive numbers in this issue
and the first missing positive won't be larger than the length of nums[]
 */

package q.q041;

public class FirstMissingPositive {
  public static void main(String[] args) {
    Solution solution = new FirstMissingPositive().new Solution();
    System.out.println(solution.firstMissingPositive(new int[] {1,2,3,10,2147483647,9}));;
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int firstMissingPositive(int[] nums) {
      int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
      int count = 0;

      for (int n : nums){
        if(n > 0){
          min = Math.min(n, min);
          max = Math.max(n, max);
          count ++;
        }
      }

      if(min > 1 || max < 0) return 1;

      int [] table = new int[count];
      for (int n: nums){
        if(n>0 && n<min+count) table[n-1] = 1;
      }

      for (int i = min; i < max;i++){
        if(table[i-1] != 1) return i;
      }

      return max + 1;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}