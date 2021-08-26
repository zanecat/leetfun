//Given an array of intervals where intervals[i] = [starti, endi], merge all ove
//rlapping intervals, and return an array of the non-overlapping intervals that co
//ver all the intervals in the input. 
//
// 
// Example 1: 
//
// 
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping.
// 
//
// 
// Constraints: 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics Array Sorting 
// 👍 8971 👎 420


package q.q056_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            List<int[]> res = new ArrayList<>();
            if (intervals.length == 1) return intervals;

            Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);

            int s=intervals[0][0];
            int e=intervals[0][1];
            for (int i = 1; i < intervals.length; i ++){
                if (s == -1) {
                    s=intervals[i][0];
                    e=intervals[i][1];
                } else {
                    if (intervals[i][0] <= e){
                        e = Math.max(e, intervals[i][1]);
                    } else {
                        res.add(new int[]{s, e});
                        s = intervals[i][0];
                        e = intervals[i][1];
                    }
                }
            }

            res.add(new int[]{s, e});

            return res.toArray(new int[res.size()][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}