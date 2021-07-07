//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[0]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以不使用代码库中的排序函数来解决这道题吗？ 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 数组 双指针 排序 
// 👍 929 👎 0


package q.q075;

public class SortColors {
    public static void main(String[] args) {
        Solution solution = new SortColors().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            int l = 0, r = nums.length - 1;

            while (l < r){
                while (l < r && nums[l] == 0){
                    l ++;
                }

                if (l < nums.length && nums[r] == 0){
                    swap(nums, l, r);
                }

                r --;
                //System.out.println(Arrays.toString(nums));
            }

            //System.out.println(11);

            l = 0;
            r = nums.length - 1;
            while (l < r){
                while (l < r &&  nums[r] == 2){
                    r --;
                }

                if (r >= 0 && nums[l] == 2){
                    swap(nums, l, r);
                }

                l ++;
                //System.out.println(Arrays.toString(nums));
            }
        }

        void swap(int[] nums, int l, int r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}