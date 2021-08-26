package q.q1229;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1,
            Comparator.comparingInt(s -> s[0])
        );
        Arrays.sort(slots2,
            Comparator.comparingInt(s -> s[0])
        );

        for (int i =0 , j = 0; i < slots1.length && j < slots2.length;){
            int s = Math.max(slots1[i][0], slots2[j][0]);
            int e = Math.min(slots1[i][1], slots2[j][1]);

            if (e - s >=duration) return List.of(s, s + duration);
            if (slots1[i][1] < slots2[j][1]){
                i ++;
            } else {
                j ++;
            }
        }

        return new ArrayList<>();
    }
}