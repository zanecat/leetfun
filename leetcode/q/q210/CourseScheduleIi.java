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
// Return the ordering of courses you should take to finish all courses. If ther
//e are many valid answers, return any of them. If it is impossible to finish all 
//courses, return an empty array. 
//
// 
// Example 1: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0]]
//Output: [0,1]
//Explanation: There are a total of 2 courses to take. To take course 1 you shou
//ld have finished course 0. So the correct course order is [0,1].
// 
//
// Example 2: 
//
// 
//Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
//Output: [0,2,1,3]
//Explanation: There are a total of 4 courses to take. To take course 3 you shou
//ld have finished both courses 1 and 2. Both courses 1 and 2 should be taken afte
//r you finished course 0.
//So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3
//].
// 
//
// Example 3: 
//
// 
//Input: numCourses = 1, prerequisites = []
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= numCourses * (numCourses - 1) 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// ai != bi 
// All the pairs [ai, bi] are distinct. 
// 
// Related Topics Depth-First Search Breadth-First Search Graph Topological Sort
// 
// 👍 4561 👎 185


package q.q210;

import java.util.*;

public class CourseScheduleIi {
    public static void main(String[] args) {
        Solution solution = new CourseScheduleIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findOrder(int n, int[][] prerequisites) {
            int[] dependings = new int[n];
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int[] pair: prerequisites){
                var dep = map.getOrDefault(pair[1], new ArrayList<>());
                dependings[pair[0]]++;
                dep.add(pair[0]);
                map.put(pair[1], dep);
            }

            Queue<Integer> todo = new LinkedList<>();

            for (int i = 0; i < n; i ++){
                if (dependings[i] == 0){
                    todo.offer(i);
                }
            }

            int index =0;
            int[] res = new int[n];
            while (!todo.isEmpty()){
                int cur = todo.poll();
                res[index++]=cur;

                var dep = map.getOrDefault(cur, new ArrayList<>());

                for (int i: dep){
                    dependings[i]--;
                    if (dependings[i] == 0){
                        todo.offer(i);
                    }
                }
            }

            if (index != n) return new int[0];
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}