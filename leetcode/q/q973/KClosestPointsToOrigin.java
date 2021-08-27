//Given an array of points where points[i] = [xi, yi] represents a point on the 
//X-Y plane and an integer k, return the k closest points to the origin (0, 0). 
//
// The distance between two points on the X-Y plane is the Euclidean distance (i
//.e., √(x1 - x2)2 + (y1 - y2)2). 
//
// You may return the answer in any order. The answer is guaranteed to be unique
// (except for the order that it is in). 
//
// 
// Example 1: 
//
// 
//Input: points = [[1,3],[-2,2]], k = 1
//Output: [[-2,2]]
//Explanation:
//The distance between (1, 3) and the origin is sqrt(10).
//The distance between (-2, 2) and the origin is sqrt(8).
//Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
//We only want the closest k = 1 points from the origin, so the answer is just [
//[-2,2]].
// 
//
// Example 2: 
//
// 
//Input: points = [[3,3],[5,-1],[-2,4]], k = 2
//Output: [[3,3],[-2,4]]
//Explanation: The answer [[-2,4],[3,3]] would also be accepted.
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= points.length <= 104 
// -104 < xi, yi < 104 
// 
// Related Topics Array Math Divide and Conquer Geometry Sorting Heap (Priority 
//Queue) Quickselect 
// 👍 3649 👎 172


package q.q973;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        Solution solution = new KClosestPointsToOrigin().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] kClosest(int[][] points, int k) {
            PriorityQueue<List<Integer>> queue = new PriorityQueue<>((l1, l2) -> l1.get(0) - l2.get(0));

            for (int i = 0; i < points.length; i ++){
                queue.add(List.of(points[i][0] * points[i][0] + points[i][1] * points[i][1], i));
            }

            List<int[]> res = new ArrayList<>();
            int i = 0;
            while (i < k){
                res.add(points[queue.poll().get(1)]);
                i++;
            }

            return res.toArray(new int[res.size()][2]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}