package q.q645;

public class SetMismatch {
    public static void main(String[] args) {
        Solution solution = new SetMismatch().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findErrorNums(int[] nums) {

            int dup = - 1, mis = -1;
            int [] table = new int [nums.length + 1];
            for (int n : nums){
                if(table[n] == 1){
                    dup = n;
                }
                table[n] = 1;
            }

            for (int i = 1; i < table.length; i ++){
                if(table[i] == 0){
                    mis = i;
                    break;
                }
            }

            return new int[] {dup, mis};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}