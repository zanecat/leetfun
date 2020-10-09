
// use counting sort to achieve O(n)

package q.q274;

public class HIndex {
  public static void main(String[] args) {
    Solution solution = new HIndex().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int hIndex(int[] c) {
      int len = c.length;
      if(len == 0) return 0;

      int [] tab = new int[len + 1];

      for(int i : c){
        tab[Math.min(i, len)] += 1;
      }

      int cnt = 0;
      for (int j = len; j >0; j--){
        cnt += tab[j];
        if(cnt >= j) return j;
      }

      return 0;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}