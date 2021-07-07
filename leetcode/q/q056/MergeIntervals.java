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
// 👍 8143 👎 398


package q.q056;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            List<List<Integer>> res = new ArrayList<>();
            if (intervals.length == 0) return new int[][]{};
            if (intervals.length == 1) return intervals;
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

            int l = 0, r = 1;
            int start = intervals[l][0];
            int end = intervals[l][1];

            while (l < intervals.length){
                if (end < intervals[r][0]) {
                    end = Math.max(end, intervals[l][1]);
                    res.add(List.of(start, end));
                    l ++;
                    r ++;
                    start = intervals[l][0];
                    end = intervals[l][1];
                } else {
                    l ++;
                    r ++;
                    end = Math.max(end, intervals[l][1]);
                }

                if (r >= intervals.length){
                    res.add(List.of(start, end));
                    break;
                }
            }

            int[][] rr = new int[res.size()][2];
            for (int i = 0; i < res.size(); i ++){
                rr[i][0] = res.get(i).get(0);
                rr[i][1] = res.get(i).get(1);
            }

            return rr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}