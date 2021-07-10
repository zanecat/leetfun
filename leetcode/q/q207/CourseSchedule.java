//There are a total of numCourses courses you have to take, labeled from 0 to nu
//mCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai,
// bi] indicates that you must take course bi first if you want to take course ai.
// 
//
// 
// For example, the pair [0, 1], indicates that to take course 0 you have to fir
//st take course 1. 
// 
//
// Return true if you can finish all courses. Otherwise, return false. 
//
// 
// Example 1: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0]]
//Output: true
//Explanation: There are a total of 2 courses to take. 
//To take course 1 you should have finished course 0. So it is possible.
// 
//
// Example 2: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
//Output: false
//Explanation: There are a total of 2 courses to take. 
//To take course 1 you should have finished course 0, and to take course 0 you s
//hould also have finished course 1. So it is impossible.
// 
//
// 
// Constraints: 
//
// 
// 1 <= numCourses <= 105 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// All the pairs prerequisites[i] are unique. 
// 
// Related Topics Depth-First Search Breadth-First Search Graph Topological Sort
// 
// 👍 6367 👎 269


package q.q207;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {
    public static void main(String[] args) {
        Solution solution = new CourseSchedule().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<Integer, List<Integer>> map;
        boolean[] done;
        int num;
        public boolean canFinish(int numCourses, int[][] prerequisites) {

            map = new HashMap<>();
            done = new boolean[numCourses + 1];
            num = numCourses;

            for (int[] pp: prerequisites){
                var ll = map.getOrDefault(pp[0], new ArrayList<>());
                ll.add(pp[1]);
                map.put(pp[0], ll);
            }

            for (int i : map.keySet()){
                if (!done[i]){
                    num --;
                    learn(i);
                }
            }

            return num >= 0;
        }

        void learn(int i){
           List<Integer> pre = map.get(i);

           if (pre == null) {
               done[i] = true;
               return;
           }

           for (int ii : pre){
               if (!done[ii]){
                   num --;
                   if (num < 0) return;
                   learn(ii);
               }
           }

           done[i] = true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}