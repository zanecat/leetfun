package q.q269;

import java.util.*;

public class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        int [] degrees = new int[26];

        Set<Character> dic = new HashSet<>();

        for (int i = 0; i < words.length; i ++){
            char[] w1 = words[i].toCharArray();
            for (char c : w1){
                dic.add(c);
            }
            for (int j = i + 1; j < words.length; j ++){
                int k = 0;
                char[] w2 = words[j].toCharArray();

                while (k < w1.length && k < w2.length && w1[k] == w2[k]){
                    k ++;
                }

                if (k < w1.length && k < w2.length){
                    var set = graph.getOrDefault(w1[k], new HashSet<>());
                    if (!set.contains(w2[k])){
                        set.add(w2[k]);
                        graph.put(w1[k], set);

                        degrees[w2[k] - 'a']++;
                    }
                } else {
                    if (w1.length > w2.length) return "";
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (char c : dic){
            if (degrees[c - 'a'] == 0) {
                queue.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            char c = queue.poll();
            sb.append(c);

            var set = graph.getOrDefault(c, new HashSet<>());

            for (char cc : set){
                degrees[cc - 'a']--;
                if (degrees[cc - 'a'] == 0){
                    queue.offer(cc);

                }
            }
        }

        if (sb.length() != dic.size()) return "";
        return sb.toString();
    }
}
